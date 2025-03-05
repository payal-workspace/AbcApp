package com.example.presentation.main.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import com.example.presentation.R


@Composable
fun EmptyStateView(
    message: String,
    modifier: Modifier = Modifier,
    messageStyle: TextStyle = MaterialTheme.typography.bodyMedium,
    textAlign: TextAlign = TextAlign.Center,
    icon: @Composable (() -> Unit)? = null
) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        icon?.invoke()
        Text(
            text = message,
            style = messageStyle,
            textAlign = textAlign,
            modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_16))
        )
    }
}
