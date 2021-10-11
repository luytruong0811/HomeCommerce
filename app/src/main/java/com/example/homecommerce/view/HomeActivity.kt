package com.example.homecommerce.view

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.WindowManager
import android.widget.LinearLayout
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.homecommerce.R
import com.example.homecommerce.adapter.*
import com.example.homecommerce.ext.*
import com.example.homecommerce.model.HomePage
import com.example.homecommerce.model.NewestProduct
import com.example.homecommerce.model.SuggestProduct
import com.example.homecommerce.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.item_top_seller.view.*
import java.util.*

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {
    private val homeViewModel: HomeViewModel by viewModels()
    private lateinit var advertisePagerAdapter: AdvertisePagerAdapter
    private lateinit var voucherPagerAdapter: VoucherPagerAdapter

    private lateinit var itemCategoryAdapter: ItemCategoryAdapter
    private lateinit var newProductAdapter: NewProductAdapter
    private lateinit var topKeyAdapter: TopKeyAdapter
    private lateinit var topSellerAdapter: TopSellerAdapter
    private lateinit var topProductAdapter: TopProductAdapter
    private lateinit var suggestProductAdapter: SuggestProductAdapter

    private lateinit var gridLayout: GridLayoutManager

    private var timer: Timer? = null
    private var totalAd = 0
    private var totalVoucher = 0



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // FIXME: 11/10/2021 initView, initEvents
        initView()
        initEvents()
        evenListenObs()


        homeViewModel.getData()

        autoSlideImageAd()
        autoSlideImageVoucher()
    }

    private fun initEvents() {
        tvViewMoreTopShop.setOnDelayClickListener {
            topSellerAdapter.setExpandState(!topSellerAdapter.isExpanded)
            updateUIButtonViewMore(topSellerAdapter.isExpanded)
        }
    }


    private fun evenListenObs() {
        homeViewModel.home.observe(this, { t ->
            when (t) {
                is HomeViewModel.HomeState.Loading -> {
                }
                is HomeViewModel.HomeState.Success -> {
                    //banner
                    val banners =
                        t.items.systemBanner?.map { it.imageAds.firstOrNull { it.lang == "vi" }?.detail.orEmpty() }
                    advertisePagerAdapter.setAdvertisePager(banners.orEmpty())
                    totalAd = banners?.size?:0

                    //category
                    itemCategoryAdapter.setItemCategory(t.items.systemCategory.orEmpty())

                    //banner
                    val voucherBanners =
                        t.items.systemBannerVoucher?.map { it.images.firstOrNull { it.lang == "vi" }?.detail.orEmpty() }
                    voucherPagerAdapter.setVoucher(voucherBanners.orEmpty())
                    totalVoucher = voucherBanners?.size?:0

                    //newProduct
                    newProductAdapter.setNewProduct(t.items.newestProduct.orEmpty())

                    //topKey
                    topKeyAdapter.setTopKey(t.items.topKeyword.orEmpty())

                    //topSeller
                    //displayTopShop(t.items.topShop)
                    topSellerAdapter.setTopSeller(t.items.topShop.orEmpty())

                    //topProduct
                    topProductAdapter.setTopProduct(t.items.topProduct.orEmpty())

                    //suggestProduct
                    suggestProductAdapter.setSuggestProduct(t.items.suggestProduct.orEmpty())

                }
                is HomeViewModel.HomeState.Error -> Toast.makeText(
                    this,
                    t.message,
                    Toast.LENGTH_SHORT
                ).show()
            }
        })

        homeViewModel.bookmarkTopProductObs.observe(this, { t->
            when (t) {
                is HomeViewModel.BookmarkTopProductState.Loading -> {
                }
                is HomeViewModel.BookmarkTopProductState.Success -> {
                    Toast.makeText(
                        this,
                        if (t.topProduct?.isBookmarked == true) getString(R.string.liked) else getString(R.string.unliked),
                        Toast.LENGTH_SHORT).show()
                    t.topProduct?.let { product ->
                        val position = topProductAdapter.findPositionAndUpdateItem(product)
                        if (position != -1) {
                            rvTopProduct.findViewHolderForAdapterPosition(position)?.let { holder ->
                                when (holder) {
                                    is TopProductAdapter.ItemProductVH -> {
                                        holder.updateBookmarkState(product.isBookmarked)
                                    }
                                }
                            } ?:kotlin.run {
                                topProductAdapter.notifyItemChanged(position)
                            }
                        }
                    }
                }
                is HomeViewModel.BookmarkTopProductState.Failed -> {
                    Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
                }
            }
        })

        homeViewModel.bookmarkNewestProductObs.observe(this, { t->
            when (t) {
                is HomeViewModel.BookmarkNewestProductState.Loading -> {
                }
                is HomeViewModel.BookmarkNewestProductState.Success -> {
                    Toast.makeText(
                        this,
                        if (t.newestProduct?.isBookmarked == true) getString(R.string.liked) else getString(R.string.unliked),
                        Toast.LENGTH_SHORT).show()
                    t.newestProduct?.let { product ->
                        val position = newProductAdapter.findPositionAndUpdateBookmarked(product.id.orEmpty(), t.newestProduct.isBookmarked)
                        if (position != -1) {
                            rvNewProduct.findViewHolderForAdapterPosition(position)?.let { holder ->
                                when (holder) {
                                    is NewProductAdapter.ItemNewProductVH -> {
                                        holder.updateBookmarkState(product.isBookmarked)
                                    }
                                }
                            } ?:kotlin.run {
                                newProductAdapter.notifyItemChanged(position)
                            }
                        }
                    }
                }
                is HomeViewModel.BookmarkNewestProductState.Failed -> {
                    Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
                }
            }
        })

        homeViewModel.bookmarkSuggestProductState.observe(this, { t->
            when (t) {
                is HomeViewModel.BookmarkSuggestProductState.Loading -> {
                }
                is HomeViewModel.BookmarkSuggestProductState.Success -> {
                    Toast.makeText(
                        this,
                        if (t.suggestProduct?.isBookmarked == true) getString(R.string.liked) else getString(R.string.unliked),
                        Toast.LENGTH_SHORT).show()
                    t.suggestProduct?.let { product ->
                        val position = suggestProductAdapter.findPositionAndUpdateItem(product)
                        if (position != -1) {
                            rvSuggest.findViewHolderForAdapterPosition(position)?.let { holder ->
                                when (holder) {
                                    is SuggestProductAdapter.ItemSuggestProduct -> {
                                        holder.updateBookmarkState(product.isBookmarked)
                                    }
                                }
                            } ?:kotlin.run {
                                suggestProductAdapter.notifyItemChanged(position)
                            }
                        }
                    }
                }
                is HomeViewModel.BookmarkSuggestProductState.Failed -> {
                    Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
                }
            }
        })
    }

    private fun initView() {
        itemCategoryAdapter = ItemCategoryAdapter(onItemClickListener = {
            Toast.makeText(this, "Click item", Toast.LENGTH_SHORT).show()
        })
        gridLayout = GridLayoutManager(this, 5)
        rvCategory.apply {
            layoutManager = gridLayout
            adapter = itemCategoryAdapter
        }

        advertisePagerAdapter = AdvertisePagerAdapter()
        voucherPagerAdapter = VoucherPagerAdapter()

        viewPagerAd.adapter = advertisePagerAdapter
        tabLayoutSystemBanner.setupWithViewPager(viewPagerAd, true)

        viewPagerVoucher.adapter = voucherPagerAdapter
        tabLayoutVoucher.setupWithViewPager(viewPagerVoucher, true)

        newProductAdapter = NewProductAdapter(
            onItemClickListener = {

            },
            onBookmarkClickListener = {
                homeViewModel.requestBookmarkNewestProduct(it)
            }
        )
        val layoutManagerNewProduct = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        rvNewProduct.apply {
            layoutManager =layoutManagerNewProduct
            adapter = newProductAdapter
        }

        topKeyAdapter = TopKeyAdapter()
        val layoutManagerTopKey = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        rvTopKey.apply {
            layoutManager = layoutManagerTopKey
            adapter = topKeyAdapter
        }


        // FIXME: 11/10/2021 kotlin: apply, let, run

        topSellerAdapter = TopSellerAdapter()
        val layoutManagerTopSeller = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        rvTopSeller.apply {
            layoutManager = layoutManagerTopSeller
            adapter = topSellerAdapter
        }

        topProductAdapter = TopProductAdapter(
            onItemClickListener = {

            }
            , onBookmarkClickListener = {
                homeViewModel.requestBookmarkTopProduct(it)
            })
        val layoutManagerTopProduct = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        rvTopProduct.apply {
            layoutManager = layoutManagerTopProduct
            adapter = topProductAdapter
        }

        suggestProductAdapter = SuggestProductAdapter(
            onItemClickListener = {

            },
            onBookmarkClickListener = {
                homeViewModel.requestBookmarkSuggestProduct(it)
            }
        )
        val layoutManagerSuggestProduct = GridLayoutManager(this, 2, RecyclerView.VERTICAL, false)
        rvSuggest.apply {
            layoutManager = layoutManagerSuggestProduct
            adapter = suggestProductAdapter
        }

    }

    private fun updateUIButtonViewMore(isExpanded: Boolean) {
        val iconRes = if (isExpanded) R.drawable.ic_up_pink else R.drawable.ic_down_pink
        tvViewMoreTopShop.text = if (isExpanded) "Rút gọn" else "Xem thêm"
        tvViewMoreTopShop.setCompoundDrawablesWithIntrinsicBounds(
            null, null, ContextCompat.getDrawable(this, iconRes), null
        )
    }

    private fun autoSlideImageAd() {
        if (timer == null) {
            timer = Timer()
        }
        timer?.schedule(object : TimerTask() {
            override fun run() {
                Handler(Looper.getMainLooper()).post {
                    run {
                        var current: Int = viewPagerAd.currentItem
                        if (current < totalAd - 1) {
                            current++
                            viewPagerAd.currentItem = current
                        } else {
                            viewPagerAd.currentItem = 0
                        }
                    }
                }
            }

        }, 500, 4000)
    }

    private fun autoSlideImageVoucher() {
        if (timer == null) {
            timer = Timer()
        }
        timer?.schedule(object : TimerTask() {
            override fun run() {
                Handler(Looper.getMainLooper()).post {
                    run {
                        var current: Int = viewPagerVoucher.currentItem
                        if (current < totalVoucher - 1) {
                            current++
                            viewPagerVoucher.currentItem = current
                        } else {
                            viewPagerVoucher.currentItem = 0
                        }
                    }
                }
            }

        }, 500, 4000)
    }

    override fun onDestroy() {
        super.onDestroy()
        if (timer != null) {
            timer!!.cancel()
            timer = null
        }
    }
}