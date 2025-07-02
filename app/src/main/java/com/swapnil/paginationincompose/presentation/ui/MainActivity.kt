package com.swapnil.paginationincompose.presentation.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.swapnil.paginationincompose.presentation.character_list.CharacterListScreen
import com.swapnil.paginationincompose.presentation.ui.theme.PaginationInComposeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PaginationInComposeTheme {
                CharacterListScreen()
            }
        }
    }
}

