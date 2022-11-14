package com.adamearle.flickrfetchr.presentation.detail

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
class DetailViewModel @Inject constructor(
    private val photoRepository: PhotoRepository
) : ViewModel() {
    var state by mutableStateOf(DetailViewState())
        private set

    fun loadPhotoInfo(photo_id: String) {
        viewModelScope.launch {
            state = state.copy(
                isLoading = true,
                error = null
            )

            photoRepository.getPhotoInfo(photo_id = photo_id).let { resource ->
                when (resource) {
                    is Resource.Success -> {
                        state = state.copy(
                            photoInfo = resource.data,
                            isLoading = false,
                            error = null
                        )
                    }
                    is Resource.Error -> {
                        state = state.copy(
                            photoInfo = null,
                            isLoading = false,
                            error = resource.message
                        )
                    }
                }
            }
        }
    }
}