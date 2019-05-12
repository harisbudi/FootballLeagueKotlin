package com.nxs.footballeaguekotlin

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

class LeagueAdapter(
    private val context: Context,
    private val list: MutableList<LeagueModel>,
    val listener: (LeagueModel) -> Unit
) : RecyclerView.Adapter<LeagueViewHolder>() {


    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): LeagueViewHolder =
        LeagueViewHolder(LayoutInflater.from(context).inflate(R.layout.league_item_card, p0, false))

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: LeagueViewHolder, position: Int) = holder.bind(list[position], listener)


}