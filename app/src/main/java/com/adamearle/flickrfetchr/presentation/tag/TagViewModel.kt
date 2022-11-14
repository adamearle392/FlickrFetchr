package com.adamearle.flickrfetchr.presentation.tag

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
class TagViewModel @Inject constructor(
    private val photoRepository: PhotoRepository
) : ViewModel() {
    var state by mutableStateOf(TagViewState())
        private set

    fun getPhotosByTag(tag: String) {
        viewModelScope.launch {
            state = state.copy(
                isLoading = true,
                error = null
            )

            photoRepository.getPhotosByTag(tag).let { resource ->
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