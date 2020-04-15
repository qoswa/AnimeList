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
import com.qoswantin.animelist.utils.smoothSnapToPosition
import javax.inject.Inject

class AnimeListFragment : BaseFragment(), AnimeListContract.View {

    @Inject
    lateinit var presenter: AnimeListContract.Presenter

    @Inject
    lateinit var animeAdapter: AnimeAdapter

    lateinit var animeListRecyclerView: RecyclerView
    var animeListLayoutManager: LinearLayoutManager? = null
    lateinit var animeListEmptyStub: TextView
    lateinit var animeListErrorStub: TextView
    lateinit var animeListProgressBar: ProgressBar

    private var savedPosition: Int = 0

    override fun onAttach(context: Context) {
        controllerComponent.inject(this)
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        savedPosition = savedInstanceState?.getInt(ANIME_LIST_POSITION_RESTORE_KEY) ?: 0
        presenter.attachView(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
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

        presenter.onCreateView(savedPosition)
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
        if (animeListLayoutManager != null) {
            outState.putInt(
                ANIME_LIST_POSITION_RESTORE_KEY,
                animeListLayoutManager!!.findFirstCompletelyVisibleItemPosition()
            )
        } else {
            // This is the case then fragment in backstack
            // and it is restored for second time, so layoutManager is not initalized.
            outState.putInt(
                ANIME_LIST_POSITION_RESTORE_KEY,
                savedPosition
            )
        }
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
