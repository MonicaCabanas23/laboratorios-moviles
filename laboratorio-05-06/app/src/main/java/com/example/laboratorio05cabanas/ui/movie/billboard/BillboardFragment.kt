package com.example.laboratorio05cabanas.ui.movie.billboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.laboratorio05cabanas.R
import com.example.laboratorio05cabanas.data.models.MovieModel
import com.example.laboratorio05cabanas.databinding.FragmentBillboardBinding
import com.example.laboratorio05cabanas.ui.movie.MovieViewModel
import com.example.laboratorio05cabanas.ui.movie.billboard.recyclerview.MovieRecyclerViewAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton

class BillboardFragment : Fragment() {

    private lateinit var binding: FragmentBillboardBinding
    private lateinit var adapter: MovieRecyclerViewAdapter

    private val viewModel: MovieViewModel by activityViewModels {
        MovieViewModel.Factory
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBillboardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.clearData()
        setRecyclerView(view)

        // Agregar película por medio del botón flotante
        binding.actionToCreateMovie.setOnClickListener{
            view.findNavController().navigate(R.id.action_billboardFragment2_to_createMovieFragment)
        }
    }

    // Inicializamos el adapter del RecyclerView
    private fun setRecyclerView(view: View) {
        binding.movieBillboardRecyclerView.layoutManager = LinearLayoutManager(view.context)

        // Se crea el objeto de adapter con función anónima como parámetro 'showSelectedMovie()'
        adapter = MovieRecyclerViewAdapter { selectedMovie ->
            showSelectedMovie(selectedMovie)
        }

        binding.movieBillboardRecyclerView.adapter = adapter
        displayMovies()
    }

    // Cuando un elemento del recyclerView ha sido seleccionado
    private fun showSelectedMovie(movie: MovieModel) {
        viewModel.setSelectedMovie(movie)
        findNavController().navigate(R.id.action_billboardFragment2_to_movieFragment)
    }

    // Después de haber inicializado el adapter. Se despliegan todas las películas
    private fun displayMovies() {
        adapter.setData(viewModel.getMovies())
        adapter.notifyDataSetChanged()
    }
}