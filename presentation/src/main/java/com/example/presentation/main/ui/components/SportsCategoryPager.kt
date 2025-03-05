package com.example.presentation.main.ui.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import com.example.presentation.R

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SportsCategoryPager(images: List<Int>, pagerState: PagerState) {
    val currentPagerState = remember { pagerState }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = dimensionResource(id = R.dimen.padding_16))
    ) {
        HorizontalPager(
            state = currentPagerState,
            modifier = Modifier
                .fillMaxWidth()
                .height(dimensionResource(id = R.dimen.padding_200))
        ) { pageIndex ->
            SportsCategoryPagerItem(imageResId = images[pageIndex])
        }
        PageIndicatorRow(images = images, pagerState = currentPagerState)
    }
}