package com.avp.view_pager2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.abs

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val imageSlides = mutableListOf<ItemSlider>()
        imageSlides.add(ItemSlider(R.drawable.nevergiveup))
        imageSlides.add(ItemSlider(R.drawable.nevergiveup))
        imageSlides.add(ItemSlider(R.drawable.nevergiveup))
        imageSlides.add(ItemSlider(R.drawable.nevergiveup))
        imageSlides.add(ItemSlider(R.drawable.nevergiveup))
        imageSlides.add(ItemSlider(R.drawable.nevergiveup))

        viewPagerImageSlider.adapter =
            SliderAdapter(imageSlides = imageSlides, viewPager2 = viewPagerImageSlider)
        viewPagerImageSlider.clipToPadding = false
        viewPagerImageSlider.clipChildren = false
        viewPagerImageSlider.offscreenPageLimit = 3
        viewPagerImageSlider.getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER
        val compositePageTransformer = CompositePageTransformer()
        compositePageTransformer.addTransformer(MarginPageTransformer(30))
        compositePageTransformer.addTransformer { page, position ->
            val r = 1 - abs(position)
            page.scaleY = 0.85F + r * 0.15F
        }
        viewPagerImageSlider.setPageTransformer(compositePageTransformer)

    }
}