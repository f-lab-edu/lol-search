package com.sun5066.presentation.main.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyListItemInfo
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import com.sun5066.base.CommonEffect
import com.sun5066.base.ui.theme.LolTheme
import com.sun5066.common.constatns.Constants
import com.sun5066.presentation.main.model.MatchInfo
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
    var searchText by rememberSaveable { mutableStateOf("Hide on bush#KR1") }
    val keyboardController = LocalSoftwareKeyboardController.current
    val lazyListState = rememberLazyListState()
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

    LaunchedEffect(lazyListState, state.matches) {
        snapshotFlow { lazyListState.layoutInfo.visibleItemsInfo }.collect { visibleItems ->
            if (shouldLoadNextPage(visibleItems, state.matches, state.isLoadingNextPage)) {
                onIntent(MainIntent.LoadMorePage)
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
                matches = state.matches,
                lazyListState = lazyListState,
                keyboardController = keyboardController,
                searchText = searchText,
                onSearchValueChange = { searchText = it },
                onSearch = { onIntent(MainIntent.Search(it)) },
            )
        }
    }
}

private fun shouldLoadNextPage(
    visibleItems: List<LazyListItemInfo>,
    images: List<MatchInfo>,
    isLoading: Boolean
): Boolean {
    val lastVisibleItemIndex = visibleItems.lastOrNull()?.index ?: return false
    val loadPosition = images.lastIndex - Constants.MATCHES_LOAD_PAGE_DISTANCE

    return lastVisibleItemIndex == loadPosition && !isLoading
}