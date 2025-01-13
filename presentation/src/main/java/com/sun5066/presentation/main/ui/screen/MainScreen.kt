package com.sun5066.presentation.main.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import com.sun5066.presentation.R
import com.sun5066.presentation.main.ui.mvi.MainIntent

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    onIntent: (MainIntent) -> Unit
) {
    Column(modifier = modifier) {
        var searchText by rememberSaveable { mutableStateOf("명령이다 죽어라#KR1") }
        val getGetAccountIntent = {
            searchText.split("#").let { onIntent(MainIntent.GetAccount(it[0], it[1])) }
        }

        Row(modifier = Modifier.fillMaxWidth()) {
            TextField(
                modifier = Modifier
                    .height(50.dp)
                    .weight(1f),
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
                keyboardActions = KeyboardActions(onSearch = { getGetAccountIntent.invoke() }),
                singleLine = true,
                value = searchText,
                onValueChange = { searchText = it }
            )
            IconButton(onClick = getGetAccountIntent) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = stringResource(R.string.search)
                )
            }
        }
    }
}