package com.example.laboratorio05.ui.actor.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.laboratorio05.MovieReviewerApplication
import com.example.laboratorio05.data.model.ActorModel
import com.example.laboratorio05.repositories.ActorRepository
import kotlinx.coroutines.launch

class ActorViewModel(private val repository: ActorRepository) : ViewModel() {
    var name = MutableLiveData("")
    var status = MutableLiveData("")

    suspend fun getAllActors() = repository.getActors()

    private fun addActor(actor: ActorModel) {
        viewModelScope.launch {
            repository.insertActor(actor)
        }
    }


    fun createActor() {
        if(!validateData()) {
            Log.d("APP TAG", WRONG_INFORMATION)
            status.value = WRONG_INFORMATION
        }

        val actor = ActorModel(name = name.value.toString())
        addActor(actor)
        clearData()
        status.value = ACTOR_CREATED
    }

    fun validateData(): Boolean {
        when {
            name.value.isNullOrEmpty() -> false
        }
        return true
    }

    fun clearData() {
        name.value = ""
    }
    fun clearStatus() {
        status.value = INACTIVE
    }

    companion object {
        val Factory = viewModelFactory {
            initializer {
                val app = this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as MovieReviewerApplication
                ActorViewModel(app.actorRepository)
            }
        }

        const val ACTOR_CREATED = "Actor created"
        const val WRONG_INFORMATION = "Wrong information"
        const val INACTIVE = ""
    }
}