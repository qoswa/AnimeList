package com.qoswantin.animelist.ui.animeList


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.qoswantin.animelist.R
import com.qoswantin.animelist.common.baseComponents.BaseFragment
import com.qoswantin.animelist.networking.JikanApi
import com.qoswantin.animelist.ui.animeList.model.Anime
import javax.inject.Inject

class AnimeListFragment(
    val presenter: AnimeListContract.Presenter
) : BaseFragment(), AnimeListContract.View {

    @Inject
    lateinit var jikanApi: JikanApi

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val viewRoot = inflater.inflate(R.layout.fragment_anime_list, container, false)
        // Inflate the layout for this fragment
        controllerComponent.inject(this)
        return viewRoot
    }

    override fun showAnimeList(animeList: List<Anime>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
