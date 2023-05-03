package com.example.laboratorio05cabanas.ui.movie

import android.text.Editable.Factory
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.laboratorio05cabanas.MovieReviewerApplication
import com.example.laboratorio05cabanas.data.models.MovieModel
import com.example.laboratorio05cabanas.repository.MovieRepository
import java.util.Base64

class MovieViewModel(private val repository: MovieRepository): ViewModel() {

    // Esto es LiveData
    var name: MutableLiveData<String> = MutableLiveData("")
    var category = MutableLiveData("")
    var description = MutableLiveData("")
    var qualification = MutableLiveData("")
    var status = MutableLiveData("")


    fun getMovies() = repository.getMovies()
    fun addMovie(movie: MovieModel) = repository.addMovie(movie)

    // Validar variables
    private fun validateData(): Boolean {
        when {
            name.value.isNullOrEmpty() -> return false
            category.value.isNullOrEmpty() -> return false
            description.value.isNullOrEmpty() -> return false
            qualification.value.isNullOrEmpty() -> return false
        }
        return true
    }

    fun createMovie(){
        if (!validateData()){
            status.value = WRONG_DATA
            return
        }

        // Si ya se hicieron las validaciones
        val newMovie = MovieModel(
            name.value.toString(),
            category.value.toString(),
            description.value.toString(),
            qualification.value.toString(),
        )

        addMovie(newMovie)
        status.value = MOVIE_CREATED
    }

    // Limpiar los datos
    fun clearData() {
        name.value = ""
        category.value = ""
        description.value = ""
        qualification.value = ""
    }

    // Reiniciar el estado al 'inicial' cuando el usuario no ha hecho nada y no se ha agregado nada
    fun clearStatus() {
        status.value = BASE_STATE
    }

    companion object {
        val Factory = viewModelFactory {
            initializer {
                val app = this[APPLICATION_KEY] as MovieReviewerApplication
                MovieViewModel(app.movieRepository)
            }
        }

        const val MOVIE_CREATED = "Movie created"
        const val WRONG_DATA = "Wrong data"
        const val BASE_STATE = ""
    }
}