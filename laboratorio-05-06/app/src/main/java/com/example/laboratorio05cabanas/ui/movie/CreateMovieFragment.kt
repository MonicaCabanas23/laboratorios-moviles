package com.example.laboratorio05cabanas.ui.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.laboratorio05cabanas.R
import com.example.laboratorio05cabanas.data.models.MovieModel
import com.example.laboratorio05cabanas.databinding.ActivityMainBinding
import com.example.laboratorio05cabanas.databinding.FragmentCreateMovieBinding

class CreateMovieFragment : Fragment() {

    private lateinit var binding: FragmentCreateMovieBinding
    private val viewModel: MovieViewModel by activityViewModels {
        MovieViewModel.Factory
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCreateMovieBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.submitButton.setOnClickListener{
            createMovie()
        }
    }

    private fun createMovie() {
        val newMovie = MovieModel(
            binding.nameValue.text.toString(),
            binding.categoryValue.text.toString(),
            binding.descriptionValue.text.toString(),
            binding.calificationValue.text.toString(),
        )

        viewModel.addMovie(newMovie)

        findNavController().popBackStack()
    }
}