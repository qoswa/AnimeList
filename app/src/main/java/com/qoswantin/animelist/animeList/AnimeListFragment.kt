package com.qoswantin.animelist.animeList


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.qoswantin.animelist.R
import com.qoswantin.animelist.animeList.AnimeListContract
import com.qoswantin.animelist.animeList.model.Anime
import com.qoswantin.animelist.common.BaseFragment
import kotlin.contracts.contract

class AnimeListFragment(
    val presenter: AnimeListContract.Presenter
) : BaseFragment(), AnimeListContract.View {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val viewRoot = inflater.inflate(R.layout.fragment_anime_list, container, false)
        // Inflate the layout for this fragment
        return viewRoot
    }

    override fun showAnimeList(animeList: List<Anime>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
