package com.example.simplechatv2.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.simplechatv2.ui.theme.ChatColors

@Composable
fun StatusBar(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(44.dp)
            .background(ChatColors.Background)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .padding(top = 14.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Time
            Text(
                text = "9:41",
                fontSize = 15.sp,
                fontWeight = FontWeight.SemiBold,
                color = ChatColors.TextPrimary,
                letterSpacing = (-0.3).sp,
                modifier = Modifier.padding(start = 5.dp)
            )
            
            Box(
                modifier = Modifier.weight(1f)
            )
            
            // Battery, WiFi, and Signal icons
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Signal icon placeholder
                Box(
                    modifier = Modifier
                        .size(17.dp, 10.67.dp)
                        .background(ChatColors.TextPrimary, RoundedCornerShape(1.dp))
                )
                
                Box(modifier = Modifier.padding(horizontal = 4.dp))
                
                // WiFi icon placeholder
                Box(
                    modifier = Modifier
                        .size(15.27.dp, 10.97.dp)
                        .background(ChatColors.TextPrimary, RoundedCornerShape(1.dp))
                )
                
                Box(modifier = Modifier.padding(horizontal = 4.dp))
                
                // Battery icon
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .size(22.dp, 10.5.dp)
                            .background(ChatColors.TextPrimary, RoundedCornerShape(2.dp))
                    )
                    Box(
                        modifier = Modifier
                            .padding(start = 1.dp)
                            .size(1.5.dp, 3.87.dp)
                            .background(ChatColors.TextPrimary, RoundedCornerShape(1.dp))
                    )
                }
            }
        }
    }
}

@Composable
fun HomeIndicator(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(34.dp)
            .background(ChatColors.Background),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .size(134.dp, 5.dp)
                .clip(CircleShape)
                .background(ChatColors.TextPrimary)
        )
    }
}