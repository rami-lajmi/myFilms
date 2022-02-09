package com.example.myfilms.app.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myfilms.R
import com.example.myfilms.model.MoviesResults
import com.example.myfilms.utils.Constants.MOVIE_POSTER_URL
import timber.log.Timber

class MovieAdapter(private val movieList: List<MoviesResults>, private val context: Context)
    : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return(ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_movie, parent, false)
        ))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie : MoviesResults = movieList[position]

        holder.bind(movie)

        val imageView: ImageView = holder.itemView.findViewById(R.id.image)

        Glide.with(context).load(MOVIE_POSTER_URL+movie.posterPath).into(imageView);

        holder.itemView.setOnClickListener {
            //TODO : Open Movie details
            Timber.d("Movie details")
        }
    }

    override fun getItemCount(): Int = movieList.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameView: TextView = itemView.findViewById(R.id.name)
        val dateView: TextView = itemView.findViewById(R.id.date)

        fun bind(movie: MoviesResults) {
            nameView.text = movie.title
            dateView.text = movie.releaseDate
        }
    }
}