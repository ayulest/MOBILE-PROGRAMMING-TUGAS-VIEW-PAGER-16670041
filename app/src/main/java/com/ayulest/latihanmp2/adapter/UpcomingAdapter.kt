package com.ayulest.latihanmp2.adapter

import android.content.Context
import android.support.v4.app.FragmentActivity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ayulest.latihanmp2.R
import com.ayulest.latihanmp2.model.ResultsItem
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.post_upcom_layout.view.*

class UpcomingAdapter(val upList: List<ResultsItem>, val context: FragmentActivity?):
        RecyclerView.Adapter<UpcomingAdapter.viewHolder>(){
    class viewHolder(view: View): RecyclerView.ViewHolder(view) {
        val tvTitle = view.tvTitle
        val tvOverview = view.tvOverview
        val tvPoster_path = view.tvPoster_path

    }
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): UpcomingAdapter.viewHolder {
        return viewHolder(LayoutInflater.from(context).inflate(R.layout.post_upcom_layout,p0,false))
    }

    override fun getItemCount(): Int {
        return upList.size
    }

    override fun onBindViewHolder(p0: UpcomingAdapter.viewHolder, p1: Int) {
        p0.tvTitle.text=upList.get(p1).title
        p0.tvOverview.text=upList.get(p1).overview
        context?.let {
            Glide.with(it)
                .load("https://image.tmdb.org/t/p/w500"+upList.get(p1).posterPath).override(512,512).into(p0.tvPoster_path)
        }


    }
}