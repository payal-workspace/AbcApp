package com.example.presentation.main

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.presentation.main.ui.base.BaseActivity
import com.example.presentation.ui.theme.GameHiveTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GameActivity : BaseActivity<SportsScreenViewModel>() {

    override val viewModel: SportsScreenViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GameHiveTheme {
                GameMainScreen(viewModel)

            }
        }
    }

}

