package com.example.presentation.main.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import com.example.presentation.R
import com.example.presentation.ui.theme.LocalCustomColorsPalette


@Composable
fun FloatingButton(onClick: () -> Unit) {
    FloatingActionButton(
        onClick = onClick,
        modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_16)),
        containerColor = LocalCustomColorsPalette.current.floatingButton,
        contentColor = LocalCustomColorsPalette.current.windowBackground
    ) {
        Icon(imageVector = Icons.Default.MoreVert, contentDescription = stringResource(id = R.string.open_bottomsheet))
    }
}