package com.igoryamamoto.choquedecultura

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.igoryamamoto.choquedecultura.Models.YoutubeItem
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_youtube_cell.view.*

class YoutubeAdapter(val videoClickListener: VideoClickListener): RecyclerView.Adapter<YoutubeViewHolder>() {

    var items: List<YoutubeItem> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

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
        holder.view.setOnClickListener {
            videoClickListener.onItemClicked(item)
        }
    }
}

class YoutubeViewHolder(var view: View): RecyclerView.ViewHolder(view) {

    fun bind(item: YoutubeItem) {
        view.titleTextView.text = item.snippet?.title
        view.descriptionTextView.text = item.snippet?.description

        Picasso.get().load(item.snippet?.thumbnails?.default?.url).into(view.thumbnailImageView)
    }

}

interface VideoClickListener {
    fun onItemClicked(item:YoutubeItem)
}
