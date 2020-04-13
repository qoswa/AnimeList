package com.qoswantin.animelist.ui.animeList.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.qoswantin.animelist.R
import com.qoswantin.animelist.ui.animeList.model.Anime
import okhttp3.internal.notify

class AnimeAdapter(
    private val context: Context
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val animeList = mutableListOf<Anime>()

    fun addAnimeList(list : List<Anime>) {
        animeList.clear()
        animeList.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return AnimeViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.anime_list_item, parent, false)
        )
    }

    override fun getItemCount() = animeList.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as AnimeViewHolder)
            .bindAnime(
                animeList[position]
            )
    }

    inner class AnimeViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        private val animeTitle: TextView = itemView.findViewById(R.id.anime_title)
        private val animeImage: ImageView = itemView.findViewById(R.id.anime_image)

        fun bindAnime(anime: Anime) {
            animeTitle.text = anime.title
            Glide.with(context)
                .load(anime.imageUrl)
                .apply( RequestOptions().override(600, 240))
                .into(animeImage)
        }

    }

}