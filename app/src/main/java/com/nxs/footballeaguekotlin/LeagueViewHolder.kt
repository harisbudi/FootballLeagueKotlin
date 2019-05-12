package com.nxs.footballeaguekotlin

import android.support.v7.widget.RecyclerView
import android.view.View
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.league_item_card.view.*

class LeagueViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
    fun bind(item: LeagueModel, listener: (LeagueModel) -> Unit) {
        view.leagueName.text = item.name
        item.image.let {
            Picasso.get().load(it).into(view.leagueImage)
        }
        view.setOnClickListener {
            listener(item)
        }
    }
}