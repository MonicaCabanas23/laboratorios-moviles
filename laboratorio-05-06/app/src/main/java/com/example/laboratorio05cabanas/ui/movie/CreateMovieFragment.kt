package com.example.laboratorio05cabanas.ui.movie

import android.graphics.Movie
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.laboratorio05cabanas.R
import com.example.laboratorio05cabanas.data.models.MovieModel
import com.example.laboratorio05cabanas.databinding.FragmentCreateMovieBinding

class CreateMovieFragment : Fragment() {

    private val viewModel: MovieViewModel by activityViewModels {
        MovieViewModel.Factory
    }

    private lateinit var binding: FragmentCreateMovieBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {

        binding = FragmentCreateMovieBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setViewModel()
        setObserver()
    }

    private fun setViewModel() {
        // variable de la vista se le asigna el viewModel
        binding.viewmodel = viewModel
    }

    private fun setObserver() {
        // Este es el mismo status definido en el ViewModel
        // con ViewLifeCycleOwner se observa el fragmento durante su ciclo de vida
        viewModel.status.observe(viewLifecycleOwner) { status ->
            when {
                status.equals(MovieViewModel.MOVIE_CREATED) -> {
                    Log.d("APP TAG", status)
                    Log.d("APP TAG", viewModel.getMovies().toString())

                    // Nos evitamos un búcle infinito con esto
                    viewModel.clearStatus()
                    viewModel.clearData()

                    findNavController().popBackStack()
                }
                status.equals(MovieViewModel.WRONG_DATA) -> {
                    Log.d("APP TAG", status)
                    viewModel.clearStatus()
                }
            }
        }
    }
}