package com.qoswantin.animelist.ui.animeList


import android.content.Context
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

class AnimeListFragment : BaseFragment(), AnimeListContract.View {

    @Inject
    lateinit var presenter: AnimeListContract.Presenter

    override fun onAttach(context: Context) {
        controllerComponent.inject(this)
        super.onAttach(context)
    }

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

    companion object {

        fun newInstance(): AnimeListFragment {
            val args = Bundle()
            val fragment = AnimeListFragment()
            fragment.arguments = args
            return fragment
        }

    }
}
