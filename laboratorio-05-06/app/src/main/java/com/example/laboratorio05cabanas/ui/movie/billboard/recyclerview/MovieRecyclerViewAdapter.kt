package com.example.laboratorio05cabanas.ui.movie.billboard.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.laboratorio05cabanas.data.models.MovieModel
import com.example.laboratorio05cabanas.data.movies
import com.example.laboratorio05cabanas.databinding.MovieItemBinding

// Esto es para todos los elementos del RecylcerView
class MovieRecyclerViewAdapter(
    private val clickListener: (MovieModel) -> Unit):
    RecyclerView.Adapter<MovieRecyclerViewHolder>() {

    private lateinit var binding: MovieItemBinding
    private val movies = ArrayList<MovieModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieRecyclerViewHolder {
        binding = MovieItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieRecyclerViewHolder(binding)
    }

    // Sirve para vincular los datos con la widget creada por ViewHolder
    override fun onBindViewHolder(holder: MovieRecyclerViewHolder, position: Int) {
        val movie = movies[position]
        holder.bind(movie, clickListener)
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    fun setData(moviesList: MutableList<MovieModel>) {
        movies.clear()
        movies.addAll(moviesList)
    }

}