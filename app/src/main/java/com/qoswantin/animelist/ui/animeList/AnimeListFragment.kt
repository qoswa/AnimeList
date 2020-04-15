package com.qoswantin.animelist.ui.animeList


import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.qoswantin.animelist.R
import com.qoswantin.animelist.common.baseComponents.BaseFragment
import com.qoswantin.animelist.common.utils.smoothSnapToPosition
import javax.inject.Inject

class AnimeListFragment : BaseFragment(), AnimeListContract.View {

    @Inject
    lateinit var presenter: AnimeListContract.Presenter

    @Inject
    lateinit var animeAdapter: AnimeAdapter

    lateinit var animeListRecyclerView: RecyclerView
    lateinit var animeListLayoutManager: LinearLayoutManager
    lateinit var animeListEmptyStub: TextView
    lateinit var animeListErrorStub: TextView
    lateinit var animeListProgressBar: ProgressBar

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
            animeListEmptyStub = findViewById(R.id.anime_list_empty_stub)
            animeListErrorStub = findViewById(R.id.anime_list_error_stub)
            animeListProgressBar = findViewById(R.id.anime_list_progress_bar)
            animeListLayoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
            animeListRecyclerView.layoutManager = animeListLayoutManager
            animeListRecyclerView.adapter = animeAdapter
        }

        presenter.attachView(this)
        presenter.onCreateView(
            savedInstanceState?.getInt(ANIME_LIST_POSITION_RESTORE_KEY)
        )
        return viewRoot
    }

    override fun onDestroyView() {
        super.onDestroyView()
        presenter.detachView()
    }

    override fun restoreListState(savedListPosition: Int?) {
        savedListPosition?.let {
            animeListRecyclerView.smoothSnapToPosition(it)
        }
    }

    override fun showProgress() {
        animeListProgressBar.visibility = VISIBLE
    }

    override fun hideProgress() {
        animeListProgressBar.visibility = GONE
    }

    override fun showEmptyStub() {
        animeListEmptyStub.visibility = VISIBLE
    }

    override fun showError() {
        animeListErrorStub.visibility = VISIBLE
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        // Do not save list cause it may be too heavy.
        outState.putInt(
            ANIME_LIST_POSITION_RESTORE_KEY,
            animeListLayoutManager.findFirstCompletelyVisibleItemPosition()
        )
    }

    companion object {

        fun newInstance(): AnimeListFragment {
            val args = Bundle()
            val fragment = AnimeListFragment()
            fragment.arguments = args
            return fragment
        }

        const val ANIME_LIST_POSITION_RESTORE_KEY = "ANIME_LIST_POSITION_RESTORE_KEY"

    }

}
