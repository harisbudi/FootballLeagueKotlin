package com.nxs.footballeaguekotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView

class MainActivity : AppCompatActivity() {

    var leagueItems: MutableList<LeagueModel> = mutableListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initdata()
        MainUI().setContentView(this)
    }

    private fun initdata() {
        val leagueName = resources.getStringArray(R.array.leagueName)
        val leagueImages = resources.obtainTypedArray(R.array.leagueImages)
        val leagueDescription = resources.getStringArray(R.array.leagueDescription)

        for (i in leagueName.indices) {
            leagueItems.add(LeagueModel(leagueName[i], leagueDescription[i], leagueImages.getResourceId(i, 0)))
        }
    }

    inner class MainUI : AnkoComponent<MainActivity> {
        override fun createView(ui: AnkoContext<MainActivity>) = with(ui) {
            verticalLayout {
                lparams(matchParent, wrapContent)

                padding = dip(8)
                recyclerView {
                    layoutManager = GridLayoutManager(context, 2)
                    adapter = LeagueAdapter(context, leagueItems) {
                        startActivity<LeagueDetail>("detail" to it)
                    }
                }
            }
        }
    }
}
