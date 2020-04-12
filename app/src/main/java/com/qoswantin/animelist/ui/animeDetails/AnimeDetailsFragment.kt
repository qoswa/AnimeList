package com.qoswantin.animelist.ui.animeDetails

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.qoswantin.animelist.R
import com.qoswantin.animelist.common.baseComponents.BaseFragment

/**
 * A simple [Fragment] subclass.
 */
class AnimeDetailsFragment : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_anime_details, container, false)
    }

    companion object {

        fun newInstance(animeId: Int): AnimeDetailsFragment {
            val args = Bundle().apply {
                putInt(ARGUMENT_ANIME_ID, animeId)
            }
            val fragment = AnimeDetailsFragment()
            fragment.arguments = args
            return fragment
        }

        const val ARGUMENT_ANIME_ID = "ARGUMENT_ANIME_ID"
    }

}
