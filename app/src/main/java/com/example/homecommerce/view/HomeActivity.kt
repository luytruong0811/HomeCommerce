package com.example.homecommerce.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.WindowManager
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.homebidu.adapter.SuggestProductAdapter
import com.example.homecommerce.R
import com.example.homecommerce.adapter.*
import com.example.homecommerce.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
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
    private lateinit var layoutManagerNewProduct: LinearLayoutManager
    private lateinit var layoutManagerTopKey: LinearLayoutManager
    private lateinit var layoutManagerTopSeller: LinearLayoutManager
    private lateinit var layoutManagerTopProduct: LinearLayoutManager
    private lateinit var layoutManagerSuggestProduct: LinearLayoutManager

    private var timer: Timer? = null
    private var totalAd = 0
    private var totalVoucher = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )
        setContentView(R.layout.activity_main)

        init()
        evenListenObs()

        homeViewModel.getHomeViewModel()

        autoSlideImageAd()
        autoSlideImageVoucher()
    }

    private fun evenListenObs() {
        homeViewModel.home.observe(this, { t ->
            when (t) {
                is HomeViewModel.HomeState.Success -> {
                    //banner
                    val banner =
                        t.items.systemBanner?.map { it.imageAds.firstOrNull { it.lang == "vi" }?.detail.orEmpty() }
                    advertisePagerAdapter.setAdvertisePager(banner.orEmpty())
                    totalAd = banner?.size!!

                    //category
                    itemCategoryAdapter.getItemCategory(t.items.systemCategory.orEmpty())

                    //banner
                    val voucherBanner =
                        t.items.systemBannerVoucher?.map { it.images.firstOrNull { it.lang == "vi" }?.detail.orEmpty() }
                    voucherPagerAdapter.getVoucher(voucherBanner.orEmpty())
                    totalVoucher = voucherBanner!!.size

                    //newProduct
                    newProductAdapter.getNewProduct(t.items.newestProduct.orEmpty())

                    //topKey
                    topKeyAdapter.getTopKey(t.items.topKeyword.orEmpty())

                    //topSeller
                    topSellerAdapter.getTopSeller(t.items.topShop.orEmpty())

                    //topProduct
                    topProductAdapter.setTopProduct(t.items.topProduct.orEmpty())

                    //suggestProduct
                    suggestProductAdapter.getSuggestProduct(t.items.suggestProduct.orEmpty())

                }
                is HomeViewModel.HomeState.Error -> Toast.makeText(
                    this,
                    t.message,
                    Toast.LENGTH_SHORT
                ).show()
            }
        })
    }

    private fun init() {
        itemCategoryAdapter = ItemCategoryAdapter()
        gridLayout = GridLayoutManager(this, 5)
        rcvCategory.layoutManager = gridLayout
        rcvCategory.adapter = itemCategoryAdapter

        advertisePagerAdapter = AdvertisePagerAdapter()
        voucherPagerAdapter = VoucherPagerAdapter()

        viewPagerAd.adapter = advertisePagerAdapter
        tabLayoutSystemBanner.setupWithViewPager(viewPagerAd, true)

        viewPagerVoucher.adapter = voucherPagerAdapter
        tabLayoutVoucher.setupWithViewPager(viewPagerVoucher, true)

        newProductAdapter = NewProductAdapter()
        layoutManagerNewProduct = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        rcvNewProduct.layoutManager = layoutManagerNewProduct
        rcvNewProduct.adapter = newProductAdapter

        topKeyAdapter = TopKeyAdapter()
        layoutManagerTopKey = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        rcvTopKey.layoutManager = layoutManagerTopKey
        rcvTopKey.adapter = topKeyAdapter

        topSellerAdapter = TopSellerAdapter()
        layoutManagerTopSeller = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        rcvTopSeller.layoutManager = layoutManagerTopSeller
        rcvTopSeller.adapter = topSellerAdapter

        topProductAdapter = TopProductAdapter()
        layoutManagerTopProduct = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        rcvTopProduct.layoutManager = layoutManagerTopProduct
        rcvTopProduct.adapter = topProductAdapter

        suggestProductAdapter = SuggestProductAdapter()
        layoutManagerSuggestProduct = GridLayoutManager(this, 2, RecyclerView.VERTICAL, false)
        rcvSuggest.layoutManager = layoutManagerSuggestProduct
        rcvSuggest.adapter = suggestProductAdapter

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