package edu.xfoleks.rabbitapp

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import edu.xfoleks.rabbitapp.data.ImagesApi
import edu.xfoleks.rabbitapp.data.RandomImage
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val api: ImagesApi
) : ViewModel() {

    private val _state = mutableStateOf(ImageState())
    val state: State<ImageState> = _state

    init {
        getRandomImage()
    }

    fun getRandomImage() {
        viewModelScope.launch {
            try {
                _state.value = state.value.copy(isLoading = true)
                _state.value = state.value.copy(
                    image = api.getRandomImage(),
                    isLoading = false
                )
            } catch (exception: Exception) {
                Log.e(TAG, "getRandomImage: ", exception)
                _state.value = state.value.copy(isLoading = false)
            }
        }
    }

    data class ImageState(
        val image: RandomImage? = null,
        val isLoading: Boolean = false
    )

    companion object {
        const val TAG = "MainViewModel"
    }
}