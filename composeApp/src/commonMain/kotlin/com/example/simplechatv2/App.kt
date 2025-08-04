package com.example.simplechatv2

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.jetbrains.compose.ui.tooling.preview.Preview
import com.example.simplechatv2.ui.screens.ChatScreen

@Composable
@Preview
fun App() {
    MaterialTheme {
        ChatScreen()
    }
}