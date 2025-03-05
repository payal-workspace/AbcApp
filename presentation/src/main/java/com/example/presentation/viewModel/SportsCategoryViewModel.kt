package com.example.presentation.viewModel

import androidx.lifecycle.viewModelScope
import com.example.domain.utils.Resource
import com.example.domain.model.SportsModel
import com.example.domain.model.SportsModelData
import com.example.domain.model.SportsModelLists
import com.example.domain.usecase.GetSportsCategoriesUseCase
import com.example.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class SportsCategoryViewModel @Inject constructor(
    private val getSportsCategoriesUseCase: GetSportsCategoriesUseCase
) : BaseViewModel() {

    private val _sportsCategories = MutableStateFlow<Resource<SportsModel?>?>(null)
    val sportsCategories: StateFlow<Resource<SportsModel?>?> = _sportsCategories

    private val _searchQuery = MutableStateFlow("")
    val searchQuery: StateFlow<String> = _searchQuery

    private val _filteredCategories = MutableStateFlow<List<SportsModelData>>(emptyList())
    val filteredCategories: StateFlow<List<SportsModelData>> = _filteredCategories

    private val _sportsCategoriesLists = MutableStateFlow<List<SportsModelLists>>(emptyList())
    val sportsCategoriesLists: StateFlow<List<SportsModelLists>> = _sportsCategoriesLists

    private val _topCharacters = MutableStateFlow("No data available")
    val topCharacters: StateFlow<String> get() = _topCharacters

    private val _showBottomSheet = MutableSharedFlow<Unit>()
    val showBottomSheet: SharedFlow<Unit> get() = _showBottomSheet

    init {
        fetchSportsCategories()
    }

    private fun fetchSportsCategories() = launchWithState(
        block = { getSportsCategoriesUseCase().first() },
        onSuccess = { resource ->
            _sportsCategories.emit(resource)
            try {
                if (resource is Resource.Success) {
                    val categories = resource.data?.data.orEmpty()
                    _filteredCategories.emit(categories)
                    updateCategoryItems(0)
                } else if (resource is Resource.Failure) {
                    _sportsCategories.emit(Resource.Failure(resource.error))
                }
            } catch (exception: Exception) {
                _sportsCategories.emit(Resource.Failure(exception))
            }

        }, onError = { exception ->
            viewModelScope.launch { _sportsCategories.emit(Resource.Failure(exception)) }
        }
    )


    fun updateCategoryItems(pageIndex: Int) {
        viewModelScope.launch {
            _sportsCategoriesLists.value =
                _filteredCategories.value.getOrNull(pageIndex)?.sportsCategoryItem.orEmpty()
            clearSearchQuery()
        }

    }

    private fun clearSearchQuery() {
        _searchQuery.value = ""
    }

    fun onSearchQueryChanged(query: String, pageIndex: Int) {
        _searchQuery.value = query
        viewModelScope.launch {
            delay(300)
            val items = _filteredCategories.value.getOrNull(pageIndex)?.sportsCategoryItem.orEmpty()
            _sportsCategoriesLists.value = if (query.isBlank()) {
                items
            } else {
                items.filter { it.sportsTitle.contains(query, ignoreCase = true) }
            }
            calculateTopCharacters()
        }
    }

    fun showBottomSheet() = viewModelScope.launch {
        calculateTopCharacters()
        _showBottomSheet.emit(Unit)
    }


    private fun calculateTopCharacters() {
        val itemsOnCurrentPage = _sportsCategoriesLists.value
        val characterCount = if (itemsOnCurrentPage.isNotEmpty()) {
            itemsOnCurrentPage
                .flatMap { it.sportsTitle.lowercase().toList() }
                .groupingBy { it }
                .eachCount()
                .entries
                .sortedByDescending { it.value }
                .take(3)
                .joinToString("\n") { "\u2022 ${it.key} -> ${it.value}" }
        } else {
            "No data available"
        }
        _topCharacters.value = characterCount
    }
}




