package com.nxs.footballeaguekotlin

import android.view.View
import android.view.ViewGroup
import org.jetbrains.anko.*
import org.jetbrains.anko.cardview.v7.cardView

class LeagueItemCard : AnkoComponent<ViewGroup> {
    companion object {
        val legImage = 1
        val legName = 2
    }

    override fun createView(ui: AnkoContext<ViewGroup>) = with(ui) {
        cardView {
            radius = 15F
            lparams(wrapContent, wrapContent) {
                margin = dip(10)
            }
            verticalLayout {
                imageView {
                    id = legImage
                    adjustViewBounds = true
                }.lparams {
                    margin = dip(8)
                }
                textView {
                    id = legName
                    textAlignment = View.TEXT_ALIGNMENT_CENTER
                }.lparams(matchParent, wrapContent) {
                    margin = dip(8)
                }

            }
        }
    }
}