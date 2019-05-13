package com.nxs.footballeaguekotlin

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import org.jetbrains.anko.AnkoContext

class LeagueAdapter(
    private val context: Context,
    private val list: MutableList<LeagueModel>,
    private val listener: (LeagueModel) -> Unit
) : RecyclerView.Adapter<LeagueViewHolder>() {


    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): LeagueViewHolder =
        LeagueViewHolder(LeagueItemCard().createView(AnkoContext.Companion.create(context, p0)))

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: LeagueViewHolder, position: Int) = holder.bind(list[position], listener)


}