package com.example.homecommerce.systemcategory

import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.lifecycle.Observer
import com.example.homecommerce.R
import com.example.homecommerce.ext.setOnDelayClickListener
import com.example.homecommerce.ext.setStatusBarColor
import com.example.homecommerce.ext.setStatusBarIconColor
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_product_by_system_category.*

@AndroidEntryPoint
class ProductBySystemCategoryActivity : AppCompatActivity() {

    private val viewModel : ProductBySystemCategoryViewModel by viewModels()
    private val viewModelActivity : SystemCategoryViewModel by viewModels()

    private val categoryId: String? by lazy { intent.getStringExtra(ProductBySystemCategoryActivity.EXTRA_CATEGORY_ID) }
    private val categoryName: String? by lazy { intent.getStringExtra(ProductBySystemCategoryActivity.EXTRA_CATEGORY_NAME) }

    private var tabLayoutAdapter : TabLayoutAdapter? = null

    private val onTabSelectedListener = object : TabLayout.OnTabSelectedListener {
        override fun onTabSelected(selectedTab: TabLayout.Tab) {
            val typeface: Typeface? = ResourcesCompat.getFont(applicationContext, R.font.lexend_semi_bold)
            selectedTab.customView?.findViewById<TextView>(R.id.title)?.let {
                it.setTextColor(ContextCompat.getColor(applicationContext, R.color.colorGrayCod))
                it.typeface = typeface
            }
            viewModelActivity.onTabSelected(tabLayoutAdapter?.getCurrentItem(selectedTab.position)?.id)
        }

        override fun onTabUnselected(unselectedTab: TabLayout.Tab) {
            val typeface: Typeface? = ResourcesCompat.getFont(applicationContext, R.font.lexend_regular)
            unselectedTab.customView?.findViewById<TextView>(R.id.title)?.let {
                it.setTextColor(ContextCompat.getColor(applicationContext, R.color.colorSilver))
                it.typeface = typeface
            }
        }

        override fun onTabReselected(tab: TabLayout.Tab) {
        }
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_by_system_category)

        setStatusBarIconColor(true)
        setStatusBarColor(R.color.backgroundColorWhite)


        setEventListener()
        registerViewModelObs()
        initTabLayout()


        categoryId?.let {
            viewModel.getCategoryFromHomePage(it)
            tvCategoryName.text = categoryName.orEmpty()
        } ?: kotlin.run {
            Toast.makeText(this, R.string.category_not_found_please_again, Toast.LENGTH_SHORT).show()
            finish()
        }


    }

    private fun registerViewModelObs() {
        viewModel.getCategoryFromHomeObs.observe(this, Observer {
            when (it) {
                is ProductBySystemCategoryViewModel.GetCategoryFromHomeState.Loading -> {
                }
                is ProductBySystemCategoryViewModel.GetCategoryFromHomeState.Success -> {
                    it.homeCategory.categories?.let { categories ->
                        tabLayoutAdapter?.updateAdapter(categories)
                    }
                }
                is ProductBySystemCategoryViewModel.GetCategoryFromHomeState.Failed -> {
                    Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
                }
            }
        })
    }


    private fun setEventListener() {
        ivBack.setOnDelayClickListener {
            onBackPressed()
        }
    }

    companion object {
        const val EXTRA_CATEGORY_ID = "extra-category-id"
        const val EXTRA_CATEGORY_NAME = "extra-category-name"
    }

    private fun initTabLayout() {
        tabLayoutAdapter = TabLayoutAdapter(supportFragmentManager, lifecycle)

        viewPager.adapter = tabLayoutAdapter
        viewPager.offscreenPageLimit = 3
        viewPager.isUserInputEnabled = true
        tabLayout.addOnTabSelectedListener(onTabSelectedListener)
        TabLayoutMediator(tabLayout, viewPager){tab, position ->
            tab.setCustomView(R.layout.view_custom_tab_layout)
            val title = tab.customView?.findViewById<TextView>(R.id.title)
            title?.text = tabLayoutAdapter?.items?.get(position)?.name
        }.attach()
    }
}