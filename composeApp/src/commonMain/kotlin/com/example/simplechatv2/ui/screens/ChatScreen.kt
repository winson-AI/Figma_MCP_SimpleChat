package com.example.simplechatv2.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.simplechatv2.data.MockData
import com.example.simplechatv2.ui.components.AdItem
import com.example.simplechatv2.ui.components.BottomTabBar
import com.example.simplechatv2.ui.components.ChatItem
import com.example.simplechatv2.ui.components.ChatSearchBar
import com.example.simplechatv2.ui.components.ChatTopBar
import com.example.simplechatv2.ui.components.StatusBar
import com.example.simplechatv2.ui.components.HomeIndicator
import com.example.simplechatv2.ui.components.StorySection

@Composable
fun ChatScreen(
    modifier: Modifier = Modifier
) {
    var selectedTab by remember { mutableStateOf(0) }
    
    Column(
        modifier = modifier.fillMaxSize()
    ) {
        // Status Bar
        StatusBar()
        
        // Top Bar
        ChatTopBar()
        
        // Search Bar
        ChatSearchBar()
        
        // Stories Section
        StorySection(stories = MockData.stories)
        
        // Chat List
        LazyColumn(
            modifier = Modifier.weight(1f),
            contentPadding = PaddingValues(bottom = 16.dp)
        ) {
            items(MockData.chats) { chat ->
                ChatItem(
                    chat = chat,
                    onClick = { 
                        // Handle chat click
                    }
                )
            }
            
            // Ad item
            item {
                AdItem(
                    chat = MockData.adChat,
                    onClick = {
                        // Handle ad click
                    }
                )
            }
        }
        
        // Bottom Tab Bar
        BottomTabBar(
            selectedTab = selectedTab,
            onTabSelected = { newTab ->
                selectedTab = newTab
            }
        )
        
        // Home Indicator
        HomeIndicator()
    }
}