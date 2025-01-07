package com.sun5066.presentation.main.ui

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.sun5066.presentation.main.ui.mvi.MainIntent

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    onIntent: (MainIntent) -> Unit
) {

    LazyColumn(modifier = modifier) {
        items(
            count = 1000,
            key = { it },
        ) { i ->
            var text by rememberSaveable { mutableStateOf("$i") }

            Box(
                modifier = Modifier.fillMaxWidth().height(80.dp),
                contentAlignment = Alignment.Center
            ) {
                TextField(value = text, onValueChange = { text = it })

                DisposableEffect(i) {
                    onDispose { Log.d("MainScreen", "onDispose i: $i") }
                }

                SideEffect {
                    Log.d("MainScreen", "SideEffect i: $i")
                }

                LaunchedEffect(i) {
                    Log.d("MainScreen", "LaunchedEffect i: $i")
                }
            }
        }
    }
}