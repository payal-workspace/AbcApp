package com.example.presentation.main.ui.base

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow


abstract class BaseViewModel : ViewModel() {

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> get() = _isLoading

    private val _errorMessage = MutableStateFlow<String?>(null)
    val errorMessage: StateFlow<String?> get() = _errorMessage

    fun setLoading(isLoading: Boolean) {
        _isLoading.value = isLoading
    }

    fun setError(message: Throwable?) {
        _errorMessage.value = message?.message
    }

    fun clearError() {
        _errorMessage.value = null
    }
}
