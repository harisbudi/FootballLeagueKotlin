package com.nxs.footballeaguekotlin

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

class LeagueViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

    private val legImage = itemView.findViewById<ImageView>(LeagueItemCard.legImage)
    private val legName = itemView.findViewById<TextView>(LeagueItemCard.legName)
    fun bind(item: LeagueModel, listener: (LeagueModel) -> Unit) {
        legName.text = item.name
        item.image.let {
            Picasso.get().load(it).into(legImage)
        }
        view.setOnClickListener {
            listener(item)
        }
    }
}