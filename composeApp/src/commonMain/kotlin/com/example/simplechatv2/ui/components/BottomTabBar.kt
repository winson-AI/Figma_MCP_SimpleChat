package com.example.simplechatv2.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.simplechatv2.ui.theme.ChatColors
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.graphics.ColorFilter
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import simplechatv2.composeapp.generated.resources.Res
import simplechatv2.composeapp.generated.resources.ic_camera
import simplechatv2.composeapp.generated.resources.ic_search


@Composable
fun BottomTabBar(
    selectedTab: Int = 0,
    onTabSelected: (Int) -> Unit = {},
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        // Top line separator
        HorizontalDivider(
            color = ChatColors.TabBarLine,
            thickness = 1.dp
        )
        
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(86.dp)
                .background(ChatColors.TabBarBackground)
                .padding(bottom = 34.dp) // Home indicator space
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 14.dp, bottom = 34.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                // Tab 1 - Chats (Active)
                TabItem(
                    isSelected = selectedTab == 0,
                    onClick = { onTabSelected(0) },
                    content = {
                        Image(
                            painter = painterResource(Res.drawable.ic_search),
                            contentDescription = "Chats",
                            modifier = Modifier.size(24.dp),
                            colorFilter = ColorFilter.tint(
                                ChatColors.TabIconInactive
                            )
                        )
                    }
                )
                
                // Tab 2 - People (with notification badge)
                TabItem(
                    isSelected = selectedTab == 1,
                    onClick = { onTabSelected(1) },
                    content = {
                        Box {
                            Image(
                                painter = painterResource(Res.drawable.ic_camera),
                                contentDescription = "People",
                                modifier = Modifier.size(24.dp),
                                colorFilter = ColorFilter.tint(
                                    ChatColors.TabIconInactive
                                )
                            )
                            
                            // Notification badge
                            Box(
                                modifier = Modifier
                                    .offset(x = 16.dp, y = (-8).dp)
                                    .size(16.dp)
                                    .background(ChatColors.NotificationBadge, CircleShape),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    "2",
                                    fontSize = 13.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.White,
                                    letterSpacing = (-0.14).sp
                                )
                            }
                        }
                    }
                )
                
                // Tab 3 - Settings
                TabItem(
                    isSelected = selectedTab == 2,
                    onClick = { onTabSelected(2) },
                    content = {
                        Image(
                            painter = painterResource(Res.drawable.ic_camera),
                            contentDescription = "Settings",
                            modifier = Modifier.size(24.dp),
                            colorFilter = ColorFilter.tint(
                                ChatColors.TabIconInactive
                            )
                        )
                    }
                )
            }
        }
    }
}

@Composable
fun TabItem(
    isSelected: Boolean,
    onClick: () -> Unit,
    content: @Composable () -> Unit
) {
    Box(
        modifier = Modifier
            .size(80.dp, 52.dp)
            .clip(CircleShape)
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        content()
    }
}