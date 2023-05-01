package com.example.laboratorio05cabanas.ui.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.laboratorio05cabanas.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class BillboardFragment : Fragment() {

    private lateinit var actionNavToCreateMovie: FloatingActionButton
    private lateinit var cardViewStarWars: CardView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_billboard, container, false)
    }

    // Para agregar listeners en el fragmento
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        actionNavToCreateMovie = view.findViewById(R.id.action_to_create_movie)
        cardViewStarWars = view.findViewById(R.id.cardView_starWars)

        cardViewStarWars.setOnClickListener {
            it.findNavController().navigate(R.id.action_billboardFragment2_to_movieFragment) }

        actionNavToCreateMovie.setOnClickListener{
            it.findNavController().navigate(R.id.action_billboardFragment2_to_createMovieFragment)
            // view.findNavController().navigate(R.id.action_billboardFragment2_to_createMovieFragment)
        }
    }

}