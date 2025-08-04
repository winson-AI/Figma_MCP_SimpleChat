package com.example.simplechatv2.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.simplechatv2.ui.theme.ChatColors
import org.jetbrains.compose.resources.painterResource
import simplechatv2.composeapp.generated.resources.Res
import simplechatv2.composeapp.generated.resources.ic_camera
import simplechatv2.composeapp.generated.resources.ic_new_message

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChatTopBar(
    title: String = "Chats",
    onCameraClick: () -> Unit = {},
    onNewMessageClick: () -> Unit = {}
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(108.dp)
            .background(ChatColors.TopBarBackground)
            .padding(top = 44.dp) // Status bar height
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .align(Alignment.BottomCenter)
                .padding(bottom = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = title,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                color = ChatColors.TextPrimary,
                letterSpacing = 0.4.sp,
                modifier = Modifier.padding(start = 52.dp) // Align with design
            )
            
            Row(
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                IconButton(
                    onClick = onCameraClick,
                    modifier = Modifier.size(40.dp)
                ) {
                    Image(
                        painter = painterResource(Res.drawable.ic_camera),
                        contentDescription = "Take a photo",
                        modifier = Modifier.size(24.dp),
                        colorFilter = ColorFilter.tint(ChatColors.TextPrimary)
                    )
                }
                
                IconButton(
                    onClick = onNewMessageClick,
                    modifier = Modifier.size(40.dp)
                ) {
                    Image(
                        painter = painterResource(Res.drawable.ic_new_message),
                        contentDescription = "New message",
                        modifier = Modifier.size(24.dp),
                        colorFilter = ColorFilter.tint(ChatColors.TextPrimary)
                    )
                }
            }
        }
    }
}