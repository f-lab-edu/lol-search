package com.sun5066.presentation.main.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.sun5066.base.CommonEffect
import com.sun5066.base.ui.theme.LolTheme
import com.sun5066.presentation.main.mvi.MainEffect
import com.sun5066.presentation.main.mvi.MainIntent
import com.sun5066.presentation.main.mvi.MainState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

@Composable
fun MainScreen(
    state: MainState,
    effect: Flow<MainEffect>,
    commonEffect: Flow<CommonEffect>,
    onIntent: (MainIntent) -> Unit
) {
    val snackBarHostState = remember { SnackbarHostState() }
    val context = LocalContext.current

    LaunchedEffect(commonEffect) {
        commonEffect.collect { commonEffect ->
            when (commonEffect) {
                is CommonEffect.ShowSnackBarRes -> launch {
                    snackBarHostState.showSnackbar(context.getString(commonEffect.resourceId))
                }
            }
        }
    }

    LolTheme {
        Scaffold(
            modifier = Modifier
                .fillMaxSize()
                .imePadding(),
            snackbarHost = { SnackbarHost(snackBarHostState) },
        ) { innerPadding ->
            SearchScreen(
                modifier = Modifier.padding(innerPadding),
                onSearch = { onIntent(MainIntent.Search(it)) }
            )
        }
    }
}