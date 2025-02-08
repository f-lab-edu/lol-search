package com.sun5066.presentation.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.sun5066.base.ui.LoadingDialog
import com.sun5066.presentation.main.ui.MainScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val state by viewModel.state.collectAsStateWithLifecycle()

            MainScreen(
                state = state,
                effect = viewModel.effect,
                commonEffect = viewModel.commonEffect,
                onIntent = viewModel::processIntent
            )

            if (state.showLoadingProgress) {
                LoadingDialog()
            }
        }
    }
}