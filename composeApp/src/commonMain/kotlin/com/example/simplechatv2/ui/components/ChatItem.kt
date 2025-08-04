package com.example.simplechatv2.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.simplechatv2.data.Chat
import com.example.simplechatv2.ui.theme.ChatColors
import org.jetbrains.compose.resources.painterResource
import simplechatv2.composeapp.generated.resources.Res
import simplechatv2.composeapp.generated.resources.ic_camera
import simplechatv2.composeapp.generated.resources.ic_read_indicator

@Composable
fun ChatItem(
    chat: Chat,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(76.dp)
            .background(ChatColors.Background)
            .clickable { onClick() }
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        // Avatar
        Box(
            modifier = Modifier
                .size(52.dp)
                .clip(CircleShape)
        ) {
            if (chat.avatarUrl != null) {
                Image(
                    painter = painterResource(Res.drawable.ic_camera),
                    contentDescription = "${chat.name}'s avatar",
                    modifier = Modifier.fillMaxSize()
                )
            } else {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(ChatColors.TextTertiary),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = chat.name.first().toString(),
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        color = ChatColors.Background
                    )
                }
            }
        }
        
        // Content
        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = chat.name,
                fontSize = 17.sp,
                fontWeight = FontWeight.Medium,
                color = ChatColors.TextPrimary,
                letterSpacing = (-0.4).sp,
                lineHeight = 22.sp,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            
            Spacer(modifier = Modifier.height(2.dp))
            
            Text(
                text = chat.lastMessage,
                fontSize = 14.sp,
                color = ChatColors.TextSecondary,
                letterSpacing = (-0.15).sp,
                lineHeight = 20.sp,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
        
        // Read indicator or timestamp
        if (chat.isRead && chat.id != "6") { // Joshua Lawrence doesn't have read indicator in design
            Image(
                painter = painterResource(Res.drawable.ic_read_indicator),
                contentDescription = "Read",
                modifier = Modifier.size(16.dp),
                colorFilter = ColorFilter.tint(ChatColors.ReadIndicator)
            )
        }
    }
}