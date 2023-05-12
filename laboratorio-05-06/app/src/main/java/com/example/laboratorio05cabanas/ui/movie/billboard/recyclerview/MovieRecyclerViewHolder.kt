package com.example.laboratorio05cabanas.ui.movie.billboard.recyclerview

import androidx.recyclerview.widget.RecyclerView
import com.example.laboratorio05cabanas.data.models.MovieModel
import com.example.laboratorio05cabanas.databinding.MovieItemBinding

// Esto es para un elemento en específico en el RecyclerView
class MovieRecyclerViewHolder(private val binding: MovieItemBinding): RecyclerView.ViewHolder(binding.root) {

    // clickListener: (MovieModel) -> Unit es una función anónima que devuelve void (Unit)
    fun bind(movie: MovieModel, clickListener: (MovieModel) -> Unit){

        // Construimos el cardview a partir de los atributos del objeto movie
        binding.movieNameTextView.text = movie.name
        binding.movieCalificationTextView.text = movie.calification

        // Cuando se le de click a la tarjeta entonces ejecutamos la función clickListener
        binding.cardView.setOnClickListener{
            clickListener(movie)
        }
    }

}