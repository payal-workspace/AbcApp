package com.example.presentation.main.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import com.example.presentation.R

@Composable
fun ErrorView(
    message: Throwable,
    onRetry: () -> Unit,
    modifier: Modifier = Modifier,
    errorTextColor: Color = Color.Red,
    errorTextStyle: TextStyle = MaterialTheme.typography.bodyMedium
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(dimensionResource(id = R.dimen.padding_16)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = message.localizedMessage ?: message.toString(),
            color = errorTextColor,
            style = errorTextStyle
        )
        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_8)))
        Button(
            onClick = onRetry,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = stringResource(id = R.string.text_retry))
        }
    }
}
