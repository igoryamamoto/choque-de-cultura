package com.igoryamamoto.choquedecultura

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.igoryamamoto.choquedecultura.Models.YoutubeItem

class YoutubeAdapter: RecyclerView.Adapter<YoutubeViewHolder>() {

    var items: List<YoutubeItem> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): YoutubeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_youtube_cell, parent, false)
        return YoutubeViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.count()
    }

    override fun onBindViewHolder(holder: YoutubeViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }
}

class YoutubeViewHolder(var view: View): RecyclerView.ViewHolder(view)
