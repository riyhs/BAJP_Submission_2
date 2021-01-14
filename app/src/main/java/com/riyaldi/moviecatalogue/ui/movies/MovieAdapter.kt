package com.riyaldi.moviecatalogue.ui.movies

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.riyaldi.moviecatalogue.data.MovieEntity
import com.riyaldi.moviecatalogue.databinding.ItemMovieBinding
import com.riyaldi.moviecatalogue.ui.detail.DetailActivity
import com.riyaldi.moviecatalogue.utils.NetworkInfo.IMAGE_URL

class MovieAdapter: RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {
    private var movies = ArrayList<MovieEntity>()

    fun setMovies(movies: List<MovieEntity>){
        if (movies.isNullOrEmpty()) return
        this.movies.clear()
        this.movies.addAll(movies)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val itemMovieBinding = ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(itemMovieBinding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(movies[position])
    }

    override fun getItemCount(): Int = movies.size

    class MovieViewHolder(private val binding: ItemMovieBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: MovieEntity) {
            with(binding) {
                tvTitle.text = movie.title
                tvGenre.text = movie.voteAverage.toString()

                Glide.with(itemView.context)
                    .load(IMAGE_URL + movie.posterPath)
                    .transform(RoundedCorners(28))
                    .into(ivPoster)

//                val bitmap = BitmapFactory.decodeResource(itemView.context.resources, movie.poster)

//                Palette.from(bitmap).generate { palette ->
//                    val defValue = itemView.resources.getColor(R.color.dark, itemView.context.theme)
//                    cardItem.setCardBackgroundColor(palette?.getDarkMutedColor(defValue) ?: defValue)
//                }

                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailActivity::class.java)
                    intent.putExtra(DetailActivity.EXTRA_FILM, movie.id)
                    intent.putExtra(DetailActivity.EXTRA_CATEGORY, "movie")

                    itemView.context.startActivity(intent)
                }
            }
        }
    }
}