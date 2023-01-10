package com.example.newheroapp.presentation.screen.splash


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newheroapp.domain.use_cases.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(private val useCases: UseCases) : ViewModel() {
    private val _onBoardingScreen = MutableStateFlow(false)
     val onBoardingScreen: StateFlow<Boolean> = _onBoardingScreen

    init {
        viewModelScope.launch(Dispatchers.IO) {
            _onBoardingScreen.value = useCases.readOnBoardingUseCase().stateIn(viewModelScope).value
        }
    }
}