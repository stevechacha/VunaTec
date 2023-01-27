package com.dev.chacha.vunatec.feature_detection.presentation.fragments.detection

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavDirections
import com.dev.chacha.vunatec.core.utils.Event
import com.dev.chacha.vunatec.core.utils.asEvent
import com.dev.chacha.vunatec.core.utils.handleThrowable
import kotlinx.coroutines.CoroutineExceptionHandler
import timber.log.Timber

class DetectionViewModel : ViewModel() {
    private val _uiState = MutableLiveData<DetectionsUIState>()
    val uiState: LiveData<DetectionsUIState> = _uiState

    private val _interactions = MutableLiveData<Event<DetectionsActions>>()
    val interactions: LiveData<Event<DetectionsActions>> = _interactions

    private val exceptionHandler = CoroutineExceptionHandler { _, exception ->
        Timber.e(exception)
        _uiState.postValue(DetectionsUIState.Error(exception.handleThrowable()))
        // val errorPair = exception.handleThrowable()
    }

    fun navigateToDetection() {
         _interactions.postValue(
             DetectionsActions.Navigate(
                 DetectionFragmentDirections.actionDetectionToPermissions()
             ).asEvent()
         )

       /* val toDetections = DetectionFragmentDirections.actionDetectionToPermissions()
        val action = DetectionsActions.Navigate(toDetections)
        _interactions.postValue(action.asEvent())*/
    }



}

sealed class DetectionsActions {
    data class Navigate(val destination: NavDirections) : DetectionsActions()
}

sealed class DetectionsUIState {

    object Loading : DetectionsUIState()

    data class Error(val message: String = "Try again") : DetectionsUIState()

    data class LimitError(val message: String) : DetectionsUIState()

    data class Message(val message: String): DetectionsUIState()
}