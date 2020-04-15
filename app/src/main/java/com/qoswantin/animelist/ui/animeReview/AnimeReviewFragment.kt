package com.qoswantin.animelist.ui.animeReview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.qoswantin.animelist.R
import com.qoswantin.animelist.common.baseComponents.BaseFragment

class AnimeReviewFragment : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_anime_review, container, false)
    }

    companion object {

        fun newInstance(animeId: Int): AnimeReviewFragment {
            val args = Bundle().apply {
                putInt(ARGUMENT_ANIME_ID, animeId)
            }
            val fragment = AnimeReviewFragment()
            fragment.arguments = args
            return fragment
        }

        const val ARGUMENT_ANIME_ID = "ARGUMENT_ANIME_ID"
    }

}
