package com.example.presentation.main.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.presentation.R
import com.example.presentation.ui.theme.LocalCustomColorsPalette
import com.example.presentation.ui.theme.LocalCustomTypography

@Composable
fun SearchBar(
    queryState: String,
    onSearchTriggered: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    val keyboardController = LocalSoftwareKeyboardController.current
    val whiteColor = LocalCustomColorsPalette.current.white
    val paddingHeight = dimensionResource(id = R.dimen.padding_55)
    val searchTextSize = dimensionResource(id = R.dimen.search_text_size).value.sp
    val borderColor = LocalCustomColorsPalette.current.floatingButton
    val cornerRadius = dimensionResource(id = R.dimen.padding_12)

    val searchIcon = remember { Icons.Default.Search }
    val clearIcon = remember { Icons.Default.Clear }

    OutlinedTextField(
        value = queryState,
        onValueChange = { newText ->
            onSearchTriggered(newText)
        },
        modifier = modifier
            .fillMaxWidth()
            .height(paddingHeight)
            .background(whiteColor, shape = RoundedCornerShape(cornerRadius))
            .border(1.2.dp, borderColor, shape = RoundedCornerShape(cornerRadius)),
        textStyle = MaterialTheme.typography.bodySmall,
        placeholder = {
            Text(
                text = stringResource(id = R.string.label_search),
                style = LocalCustomTypography.current.bodyNormal.copy(fontSize = searchTextSize),
                maxLines = 1,
            )
        },
        leadingIcon = {
            Icon(
                imageVector = searchIcon,
                contentDescription = stringResource(id = R.string.text_search_icon),
                tint = borderColor
            )
        },
        trailingIcon = {
            if (queryState.isNotEmpty()) {
                Icon(
                    imageVector = clearIcon,
                    contentDescription = stringResource(id = R.string.text_clear_input),
                    modifier = Modifier.clickable {
                        onSearchTriggered("")
                        keyboardController?.hide()
                    },
                    tint = borderColor
                )
            }
        },
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
        keyboardActions = KeyboardActions(
            onDone = {
                keyboardController?.hide()
                onSearchTriggered(queryState.lowercase().trim())
            }
        ),
        maxLines = 1,
        colors = OutlinedTextFieldDefaults.colors(
            unfocusedBorderColor = Color.Transparent
        ),
        shape = RoundedCornerShape(cornerRadius)
    )

}

@Preview
@Composable
fun PreviewSearchBar() {
    SearchBar(
        queryState = "sports",
        onSearchTriggered = {}
    )
}