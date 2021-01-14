package com.riyaldi.moviecatalogue.ui.tvshows

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.riyaldi.moviecatalogue.data.TvShowEntity
import com.riyaldi.moviecatalogue.databinding.ItemMovieBinding
import com.riyaldi.moviecatalogue.ui.detail.DetailActivity
import com.riyaldi.moviecatalogue.utils.NetworkInfo.IMAGE_URL

class TvShowAdapter: RecyclerView.Adapter<TvShowAdapter.TvShowViewHolder>() {
    private var tvShows = ArrayList<TvShowEntity>()

    fun setTvShows(tvShows: List<TvShowEntity>) {
        if (tvShows.isNullOrEmpty()) return
        this.tvShows.clear()
        this.tvShows.addAll(tvShows)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowViewHolder {
        val itemMovieBinding = ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TvShowViewHolder(itemMovieBinding)
    }

    override fun onBindViewHolder(holder: TvShowViewHolder, position: Int) {
        holder.bind(tvShows[position])
    }

    override fun getItemCount(): Int = tvShows.size

    class TvShowViewHolder(private val binding: ItemMovieBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(tvShow: TvShowEntity) {
            with(binding) {
                tvTitle.text = tvShow.name
                tvGenre.text = tvShow.voteAverage.toString()

                Glide.with(binding.root.context)
                    .load(IMAGE_URL + tvShow.posterPath)
                    .transform(RoundedCorners(28))
                    .into(ivPoster)

//                val bitmap = BitmapFactory.decodeResource(itemView.context.resources, tvShow.poster)
//
//                Palette.from(bitmap).generate { palette ->
//                    val defValue = itemView.resources.getColor(R.color.dark, itemView.context.theme)
//                    cardItem.setCardBackgroundColor(palette?.getDarkMutedColor(defValue) ?: defValue)
//                }

                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailActivity::class.java)
                    intent.putExtra(DetailActivity.EXTRA_FILM, tvShow.id)
                    intent.putExtra(DetailActivity.EXTRA_CATEGORY, "tvShow")

                    itemView.context.startActivity(intent)
                }
            }
        }
    }
}