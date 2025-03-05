package com.example.presentation.main

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.domain.utils.Resource
import com.example.domain.utils.Resource.*
import com.example.presentation.main.ui.components.EmptyStateView
import com.example.presentation.main.ui.components.ErrorView
import com.example.presentation.main.ui.components.FloatingButton
import com.example.presentation.main.ui.components.LoadingIndicator
import com.example.presentation.main.ui.components.SportsContent
import com.example.presentation.main.ui.components.TopCharactersBottomSheet
import kotlinx.coroutines.launch

@SuppressLint("UnrememberedMutableState")
@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Composable
fun GameMainScreen(viewModel: SportsScreenViewModel = hiltViewModel()) {
    val categories by viewModel.filteredCategories.collectAsState()
    val searchQuery by viewModel.searchQuery.collectAsState()
    val topCharacters by viewModel.topCharacters.collectAsState(initial = "No data available")
    val sportsCategories by viewModel.sportsCategories.collectAsState()
    var isBottomSheetVisible by remember { mutableStateOf(false) }
    val filteredImages  by viewModel.filteredImages.collectAsState()
    val filteredList by viewModel.filteredList.collectAsState()

    val sheetState = rememberModalBottomSheetState()
    val pagerState = rememberPagerState(initialPage = 0) { categories.size }

    LaunchedEffect(searchQuery, pagerState.currentPage) {
        viewModel.onSearchQueryChanged(searchQuery, pagerState.currentPage)
    }
    LaunchedEffect(pagerState.currentPage) {
        viewModel.updateCategoryItems(pagerState.currentPage)
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        floatingActionButton = {
            FloatingButton {
                viewModel.showBottomSheet()
                isBottomSheetVisible = true
            }
        },
        floatingActionButtonPosition = FabPosition.End
    ) { padding ->
        Box(modifier = Modifier.fillMaxSize()) {
            when (sportsCategories) {
                is Loading -> LoadingIndicator()
                is Failure -> ErrorView(
                    message = (sportsCategories as Failure).error,
                    onRetry = { viewModel.fetchSportsCategories() }
                )
                is Success -> {
                    if (categories.isEmpty()) {
                        EmptyStateView("No categories available")
                    } else {
                        SportsContent(
                            categories = categories,
                            filteredImages = filteredImages,
                            filteredList = filteredList,
                            pagerState = pagerState,
                            searchQuery = searchQuery,
                            padding = padding,
                            onSearchTriggered = { query ->
                                viewModel.onSearchQueryChanged(query, pagerState.currentPage)
                            }
                        )
                    }
                }
            }
            if (isBottomSheetVisible) {
                TopCharactersBottomSheet(
                    topCharacters = topCharacters,
                    onClose = { isBottomSheetVisible = false },
                    sheetState = sheetState,
                    categoriesCount = filteredList.size
                )
            }
        }
    }
}

