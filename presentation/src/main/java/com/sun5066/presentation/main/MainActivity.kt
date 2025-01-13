package com.sun5066.presentation.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import com.sun5066.base.ui.theme.LolTheme
import com.sun5066.presentation.main.ui.screen.MainScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LolTheme {
                val snackBarHostState = remember { SnackbarHostState() }
                val (showProgressIndicator, setShowProgressIndicator) = rememberSaveable {
                    mutableStateOf(false)
                }

//                viewModel.sideEffect.CollectSideEffect { sideEffect ->
//                    when (sideEffect) {
//                        is CommonSideEffect.ShowSnackBarRes -> {
//                            launch { snackBarHostState.showSnackbar(getString(sideEffect.res)) }
//                        }
//
//                        is CommonSideEffect.LoadingIndicator -> {
//                            setShowProgressIndicator(sideEffect.show)
//                        }
//                    }
//                }

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    snackbarHost = { SnackbarHost(snackBarHostState) }
                ) { innerPadding ->
                    MainScreen(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding),
                        onIntent = viewModel::processIntent
                    )
//                    LoadingDialog(showProgressIndicator)
                }
            }
        }
    }
}