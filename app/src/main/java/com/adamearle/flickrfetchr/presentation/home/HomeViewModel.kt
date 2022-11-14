package com.adamearle.flickrfetchr.presentation.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.adamearle.flickrfetchr.domain.repository.PhotoRepository
import com.adamearle.flickrfetchr.domain.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val photoRepository: PhotoRepository
) : ViewModel() {
    var state by mutableStateOf(HomeViewState())
        private set

    fun loadGallery() {
        viewModelScope.launch {
            state = state.copy(
                isLoading = true,
                error = null
            )

            photoRepository.getGallery().let { resource ->
                when (resource) {
                    is Resource.Success -> {
                        state = state.copy(
                            gallery = resource.data,
                            isLoading = false,
                            error = null
                        )
                    }
                    is Resource.Error -> {
                        state = state.copy(
                            gallery = null,
                            isLoading = false,
                            error = resource.message
                        )
                    }
                }
            }
        }
    }
}