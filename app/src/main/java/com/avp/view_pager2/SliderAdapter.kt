package com.avp.view_pager2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import kotlinx.android.synthetic.main.item_slide_container.view.*

class SliderAdapter(val imageSlides: List<ItemSlider>, val viewPager2: ViewPager2) :
    RecyclerView.Adapter<SliderAdapter.SliderViewHolder>() {

    class SliderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SliderViewHolder {
        return SliderViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_slide_container, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return imageSlides.size
    }

    override fun onBindViewHolder(holder: SliderViewHolder, position: Int) {
        holder.itemView.roundedImageSlide.setImageResource(imageSlides[position].image)
    }
}