package com.nxs.footballeaguekotlin

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.squareup.picasso.Picasso
import org.jetbrains.anko.*

class LeagueDetail : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val item = intent.getParcelableExtra<LeagueModel>("detail")
        MainUI(item).setContentView(this)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }

    inner class MainUI(val item: LeagueModel) : AnkoComponent<LeagueDetail> {
        private val header = 1
        private val leagueImage = 2
        private val name = 3
        private val description = 4
        override fun createView(ui: AnkoContext<LeagueDetail>) = with(ui) {
            scrollView {
                lparams(matchParent, matchParent)
                verticalLayout {
                    lparams(matchParent, wrapContent)
                    relativeLayout {
                        lparams(matchParent, matchParent)
                        view {
                            id = header
                            setBackgroundColor(resources.getColor(R.color.colorPrimary))
                        }.lparams(matchParent, dip(150))

                        imageView {
                            id = leagueImage
                            Picasso.get().load(item.image).into(this)
                        }.lparams(dip(150), dip(150)) {
                            centerHorizontally()
                            below(header)
                            topMargin = -dip(150 / 2)
                        }
                    }

                    textView {
                        id = name
                        text = item.name
                        textSize = 19F
                        textColor = Color.BLACK

                    }.lparams {
                        margin = dip(16)
                    }
                    textView {
                        id = description
                        text = item.description
                        textSize = 14F
                    }.lparams {
                        margin = dip(16)
                    }
                }
            }
        }
    }
}
