package com.example.presentation.main

import androidx.lifecycle.viewModelScope
import com.example.domain.utils.Resource
import com.example.domain.model.SportsModel
import com.example.domain.model.SportsModelData
import com.example.domain.model.SportsModelLists
import com.example.domain.usecase.GetSportsCategoriesUseCase
import com.example.presentation.main.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SportsScreenViewModel @Inject constructor(
    private val getSportsCategoriesUseCase: GetSportsCategoriesUseCase
) : BaseViewModel() {

    private val _sportsCategories = MutableStateFlow<Resource<SportsModel?>>(Resource.Loading)
    val sportsCategories: StateFlow<Resource<SportsModel?>> = _sportsCategories

    private val _searchQuery = MutableStateFlow("")
    val searchQuery: StateFlow<String> = _searchQuery

    private val _filteredCategories = MutableStateFlow<List<SportsModelData>>(emptyList())
    val filteredCategories: StateFlow<List<SportsModelData>> = _filteredCategories

    private val _sportsCategoriesLists = MutableStateFlow<List<SportsModelLists>>(emptyList())
    val sportsCategoriesLists: StateFlow<List<SportsModelLists>> = _sportsCategoriesLists

    private val _topCharacters = MutableStateFlow("No data available")
    val topCharacters: StateFlow<String> get() = _topCharacters

    private val _showBottomSheet = MutableStateFlow(false)
    val showBottomSheet: StateFlow<Boolean> get() = _showBottomSheet

    private val _filteredImages = MutableStateFlow<List<Int>>(emptyList())
    val filteredImages: StateFlow<List<Int>> = _filteredImages

    private val _filteredList = MutableStateFlow<List<SportsModelLists>>(emptyList())
    val filteredList: StateFlow<List<SportsModelLists>> = _filteredList

    init {
        fetchSportsCategories()
    }

    fun fetchSportsCategories() = viewModelScope.launch {
        setLoading(true)
        try {
            val resource = getSportsCategoriesUseCase().first()
            _sportsCategories.emit(resource)
            if (resource is Resource.Success) {
                val categories = resource.data?.data.orEmpty()
                _filteredCategories.emit(categories)
                updateFilteredImages(categories)
            } else if (resource is Resource.Failure) {
                setError(resource.error)
            }
        }catch (e: Exception){
            _sportsCategories.emit(Resource.Failure(e))
            setLoading(false)
        }
        finally {
            setLoading(false)
        }
    }

    fun updateCategoryItems(pageIndex: Int) {
        val items = _filteredCategories.value.getOrNull(pageIndex)?.sportsCategoryItem.orEmpty()
        _sportsCategoriesLists.value = items
        _filteredList.value = items
        _searchQuery.value = ""
    }

    private fun updateFilteredImages(categories: List<SportsModelData>) {
        _filteredImages.value = categories.map { it.sportsCategoryImageUrl }
    }

    fun onSearchQueryChanged(query: String, pageIndex: Int) {
        _searchQuery.value = query
        val items = _filteredCategories.value.getOrNull(pageIndex)?.sportsCategoryItem.orEmpty()
        _sportsCategoriesLists.value = if (query.isBlank()) {
            items
        } else {
            items.filter { it.sportsTitle.contains(query, ignoreCase = true) }
        }
        calculateTopCharacters()
    }

    fun showBottomSheet() = viewModelScope.launch {
        calculateTopCharacters()
        _showBottomSheet.emit(true)
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


