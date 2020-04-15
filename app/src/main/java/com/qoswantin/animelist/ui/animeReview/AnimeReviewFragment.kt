package com.qoswantin.animelist.ui.animeReview

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView

import com.qoswantin.animelist.R
import com.qoswantin.animelist.common.baseComponents.BaseFragment
import javax.inject.Inject

class AnimeReviewFragment : BaseFragment(), AnimeReviewContract.View {

    @Inject
    lateinit var presenter: AnimeReviewContract.Presenter

    lateinit var errorStub: TextView
    lateinit var reviewTextView: TextView
    lateinit var progressBar: ProgressBar

    override fun onAttach(context: Context) {
        super.onAttach(context)
        controllerComponent.inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.attachView(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_anime_review, container, false)
        rootView.run {
            errorStub = findViewById(R.id.review_error_stub)
            reviewTextView = findViewById(R.id.review_text_view)
            progressBar = findViewById(R.id.review_progress_bar)
        }

        presenter.onCreateView(
            requireArguments().getInt(ARGUMENT_ANIME_ID)
        )

        return rootView
    }

    override fun onDestroyView() {
        super.onDestroyView()
        presenter.detachView()
    }

    override fun showAnimeReview(animeReview: String) {
        reviewTextView.text = animeReview
    }

    override fun showProgress() {
        progressBar.visibility = VISIBLE
    }

    override fun hideProgress() {
        progressBar.visibility = GONE
    }

    override fun showError() {
        errorStub.visibility = VISIBLE
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
