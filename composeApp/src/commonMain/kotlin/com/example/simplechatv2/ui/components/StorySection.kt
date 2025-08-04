package com.example.simplechatv2.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.simplechatv2.data.Story
import com.example.simplechatv2.ui.theme.ChatColors
import org.jetbrains.compose.resources.painterResource
import simplechatv2.composeapp.generated.resources.Res
import simplechatv2.composeapp.generated.resources.ic_add_story
import simplechatv2.composeapp.generated.resources.ic_camera

@Composable
fun StorySection(
    stories: List<Story>,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(106.dp)
            .background(ChatColors.Background)
    ) {
        LazyRow(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(horizontal = 12.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            items(stories) { story ->
                StoryItem(story = story)
            }
        }
    }
}

@Composable
fun StoryItem(
    story: Story,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.width(65.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Box(
            modifier = Modifier
                .size(52.dp)
                .clip(CircleShape),
            contentAlignment = Alignment.Center
        ) {
            if (story.isYourStory) {
                // Your story with plus icon
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(ChatColors.Background, CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(Res.drawable.ic_add_story),
                        contentDescription = "Add to your story",
                        modifier = Modifier.size(20.dp),
                        colorFilter = ColorFilter.tint(ChatColors.TextPrimary)
                    )
                }
            } else {
                // Profile photo
                if (story.avatarUrl != null) {
                    Image(
                        painter = painterResource(Res.drawable.ic_camera),
                        contentDescription = "${story.userName}'s avatar",
                        modifier = Modifier.fillMaxSize()
                    )
                } else {
                    // Fallback placeholder
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(ChatColors.TextTertiary, CircleShape),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            story.userName.first().toString(),
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                            color = ChatColors.Background
                        )
                    }
                }
            }
        }
        
        Text(
            text = story.userName,
            fontSize = 13.sp,
            color = ChatColors.TextTertiary,
            textAlign = TextAlign.Center,
            letterSpacing = (-0.08).sp,
            lineHeight = 18.sp,
            modifier = Modifier.fillMaxWidth()
        )
    }
}