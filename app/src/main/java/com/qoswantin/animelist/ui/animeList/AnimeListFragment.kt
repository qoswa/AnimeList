package com.qoswantin.animelist.ui.animeList


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

import com.qoswantin.animelist.R
import com.qoswantin.animelist.common.baseComponents.BaseFragment
import com.qoswantin.animelist.di.controller.ControllerModule.Companion.ANIME_ADAPTER
import com.qoswantin.animelist.networking.JikanApi
import com.qoswantin.animelist.ui.animeList.adapter.AnimeAdapter
import com.qoswantin.animelist.ui.animeList.model.Anime
import javax.inject.Inject
import javax.inject.Named

class AnimeListFragment : BaseFragment(), AnimeListContract.View {

    @Inject
    lateinit var presenter: AnimeListContract.Presenter

    @Inject
    lateinit var animeAdapter: AnimeAdapter

    lateinit var animeListRecyclerView: RecyclerView

    override fun onAttach(context: Context) {
        controllerComponent.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val viewRoot = inflater.inflate(R.layout.fragment_anime_list, container, false)
        viewRoot.run {
            animeListRecyclerView = findViewById(R.id.anime_recycler_view)
            animeListRecyclerView.adapter = animeAdapter
        }

        return viewRoot
    }

    override fun onStart() {
        super.onStart()
        presenter.attachView(this)
    }

    override fun showAnimeList(animeList: List<Anime>) {
        TODO("Not yet implemented")
    }

    override fun onStop() {
        super.onStop()
        presenter.detachView()
    }

    companion object {

        fun newInstance(): AnimeListFragment {
            val args = Bundle()
            val fragment = AnimeListFragment()
            fragment.arguments = args
            return fragment
        }

    }
}
