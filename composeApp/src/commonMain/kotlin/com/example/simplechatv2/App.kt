package com.example.simplechatv2

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import simplechatv2.composeapp.generated.resources.Res
import simplechatv2.composeapp.generated.resources.ad_pixsellz
import simplechatv2.composeapp.generated.resources.avatar_andrew
import simplechatv2.composeapp.generated.resources.avatar_joshua
import simplechatv2.composeapp.generated.resources.avatar_karen
import simplechatv2.composeapp.generated.resources.avatar_maisy
import simplechatv2.composeapp.generated.resources.avatar_martin
import simplechatv2.composeapp.generated.resources.avatar_maximillian
import simplechatv2.composeapp.generated.resources.avatar_martha
import simplechatv2.composeapp.generated.resources.ic_add_story
import simplechatv2.composeapp.generated.resources.ic_battery
import simplechatv2.composeapp.generated.resources.ic_camera
import simplechatv2.composeapp.generated.resources.ic_chats
import simplechatv2.composeapp.generated.resources.ic_new_message
import simplechatv2.composeapp.generated.resources.ic_people
import simplechatv2.composeapp.generated.resources.ic_read_indicator
import simplechatv2.composeapp.generated.resources.ic_search
import simplechatv2.composeapp.generated.resources.ic_settings
import simplechatv2.composeapp.generated.resources.ic_signal
import simplechatv2.composeapp.generated.resources.ic_wifi

// Data Classes
data class Chat(
    val id: String,
    val name: String,
    val lastMessage: String,
    val timestamp: String,
    val isRead: Boolean = false,
    val avatarUrl: String? = null
)

data class Story(
    val id: String,
    val userName: String,
    val isYourStory: Boolean = false,
    val avatarUrl: String? = null
)

// Theme Colors
object ChatColors {
    val Background = Color(0xFFFFFFFF)
    val TopBarBackground = Color(0x99FFFFFF) // 60% opacity white
    val SearchBackground = Color(0x0D000000) // 5% opacity black
    val TabBarBackground = Color(0x99FFFFFF) // 60% opacity white
    val TabBarLine = Color(0xFFA6A6AA)

    val TextPrimary = Color(0xFF000000)
    val TextSecondary = Color(0x80000000) // 50% opacity black
    val TextTertiary = Color(0x59000000) // 35% opacity blackk
    val SearchPlaceholder = Color(0xFF8E8E93)
    val LinkColor = Color(0xFF0084FE)

    val ReadIndicator = Color(0xFF5AD439)
    val TabIconInactive = Color(0xFF8E8E93)
    val NotificationBadge = Color(0xFF5AD439)
}

// Mock Data
object MockData {
    val chats = listOf(
        Chat(
            id = "1",
            name = "Maximillian Jacobson",
            lastMessage = "Messenger UI · Thu",
            timestamp = "Thu",
            isRead = false,
            avatarUrl = "avatar_maximillian.png"
        ),
        Chat(
            id = "2",
            name = "Martin Randolph",
            lastMessage = "You: What's man! · 9:40 AM",
            timestamp = "9:40 AM",
            isRead = true,
            avatarUrl = "avatar_martin.png"
        ),
        Chat(
            id = "3",
            name = "Andrew Parker",
            lastMessage = "You: Ok, thanks! · 9:25 AM",
            timestamp = "9:25 AM",
            isRead = true,
            avatarUrl = "avatar_andrew.png"
        ),
        Chat(
            id = "4",
            name = "Karen Castillo",
            lastMessage = "You: Ok, See you in To… · Fri",
            timestamp = "Fri",
            isRead = true,
            avatarUrl = "avatar_karen.png"
        ),
        Chat(
            id = "5",
            name = "Maisy Humphrey",
            lastMessage = "Have a good day, Maisy! · Fri",
            timestamp = "Fri",
            isRead = true,
            avatarUrl = "avatar_maisy.png"
        ),
        Chat(
            id = "6",
            name = "Joshua Lawrence",
            lastMessage = "The business plan loo… · Thu",
            timestamp = "Thu",
            isRead = false,
            avatarUrl = "avatar_joshua.png"
        )
    )

    val stories = listOf(
        Story(
            id = "your_story",
            userName = "Your story",
            isYourStory = true
        ),
        Story(
            id = "1",
            userName = "Joshua",
            avatarUrl = "avatar_joshua.png"
        ),
        Story(
            id = "2",
            userName = "Martin",
            avatarUrl = "avatar_martin.png"
        ),
        Story(
            id = "3",
            userName = "Karen",
            avatarUrl = "avatar_karen.png"
        ),
        Story(
            id = "4",
            userName = "Martha",
            avatarUrl = "avatar_martha.png"
        )
    )

    val adChat = Chat(
        id = "ad",
        name = "Pixsellz",
        lastMessage = "Make design process easier…",
        timestamp = "",
        isRead = false,
        avatarUrl = "ad_pixsellz.png"
    )
}

// Components
@Composable
fun StatusBar(modifier: Modifier = Modifier) {
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
                .padding(top = 20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "9:41",
                fontSize = 15.sp,
                fontWeight = FontWeight.SemiBold,
                color = ChatColors.TextPrimary,
                letterSpacing = (-0.3).sp,
                modifier = Modifier.padding(start = 5.dp)
            )

            Box(modifier = Modifier.weight(1f))

            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(Res.drawable.ic_signal),
                    contentDescription = "Mobile signal",
                    modifier = Modifier.size(17.dp, 11.dp),
                    colorFilter = ColorFilter.tint(ChatColors.TextPrimary)
                )

                Box(modifier = Modifier.padding(horizontal = 4.dp))

                Image(
                    painter = painterResource(Res.drawable.ic_wifi),
                    contentDescription = "WiFi",
                    modifier = Modifier.size(15.dp, 11.dp),
                    colorFilter = ColorFilter.tint(ChatColors.TextPrimary)
                )

                Box(modifier = Modifier.padding(horizontal = 4.dp))

                Image(
                    painter = painterResource(Res.drawable.ic_battery),
                    contentDescription = "Battery",
                    modifier = Modifier.size(22.dp, 11.dp),
                    colorFilter = ColorFilter.tint(ChatColors.TextPrimary)
                )
            }
        }
    }
}

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
            .background(Color.White)
            .padding(top = 44.dp)
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
            Image(
                painter = painterResource(Res.drawable.ad_pixsellz),
                contentDescription = "",
                modifier = Modifier.size(30.dp)
            )

            Text(
                text = title,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                letterSpacing = 0.4.sp,
                modifier = Modifier.padding(start = 0.5.dp)
            )

            Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChatSearchBar(
    modifier: Modifier = Modifier,
    onSearchTextChange: (String) -> Unit = {}
) {
    var searchText by remember { mutableStateOf("") }

    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(48.dp)
            .background(ChatColors.Background)
            .padding(horizontal = 16.dp),
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(36.dp)
                .background(ChatColors.SearchBackground, RoundedCornerShape(10.dp))
                .padding(start = 8.dp, end = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            Image(
                painter = painterResource(Res.drawable.ic_search),
                contentDescription = "Search",
                modifier = Modifier.size(15.5.dp),
                colorFilter = ColorFilter.tint(ChatColors.SearchPlaceholder)
            )

            BasicTextField(
                value = searchText,
                onValueChange = { newText ->
                    searchText = newText
                    onSearchTextChange(newText)
                },
                textStyle = TextStyle(
                    fontSize = 17.sp,
                    color = ChatColors.TextPrimary,
                    letterSpacing = (-0.41).sp
                ),
                decorationBox = { innerTextField ->
                    if (searchText.isEmpty()) {
                        Text(
                            text = "Search",
                            style = TextStyle(
                                fontSize = 17.sp,
                                color = ChatColors.SearchPlaceholder,
                                letterSpacing = (-0.41).sp
                            )
                        )
                    }
                    innerTextField()
                },
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

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
                if (story.avatarUrl != null) {
                    val avatarResource = when (story.avatarUrl) {
                        "avatar_joshua.png" -> Res.drawable.avatar_joshua
                        "avatar_martin.png" -> Res.drawable.avatar_martin
                        "avatar_karen.png" -> Res.drawable.avatar_karen
                        "avatar_martha.png" -> Res.drawable.avatar_martha
                        else -> Res.drawable.avatar_joshua
                    }
                    Image(
                        painter = painterResource(avatarResource),
                        contentDescription = "${story.userName}'s avatar",
                        modifier = Modifier.fillMaxSize()
                    )
                } else {
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
        Box(
            modifier = Modifier
                .size(52.dp)
                .clip(CircleShape)
        ) {
            if (chat.avatarUrl != null) {
                val avatarResource = when (chat.avatarUrl) {
                    "avatar_maximillian.png" -> Res.drawable.avatar_maximillian
                    "avatar_martin.png" -> Res.drawable.avatar_martin
                    "avatar_andrew.png" -> Res.drawable.avatar_andrew
                    "avatar_karen.png" -> Res.drawable.avatar_karen
                    "avatar_maisy.png" -> Res.drawable.avatar_maisy
                    "avatar_joshua.png" -> Res.drawable.avatar_joshua
                    else -> Res.drawable.avatar_joshua
                }
                Image(
                    painter = painterResource(avatarResource),
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

        if (chat.isRead && chat.id != "6") {
            Image(
                painter = painterResource(Res.drawable.ic_read_indicator),
                contentDescription = "Read",
                modifier = Modifier.size(16.dp),
                colorFilter = ColorFilter.tint(ChatColors.ReadIndicator)
            )
        }
    }
}

@Composable
fun AdItem(
    chat: Chat,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(76.dp)
            .background(ChatColors.Background)
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Box(
            modifier = Modifier
                .size(52.dp)
                .clip(CircleShape)
        ) {
            if (chat.avatarUrl != null) {
                Image(
                    painter = painterResource(Res.drawable.ad_pixsellz),
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
                        text = "P",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        color = ChatColors.Background
                    )
                }
            }
        }

        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.Center
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = chat.name,
                    fontSize = 17.sp,
                    fontWeight = FontWeight.Medium,
                    color = ChatColors.TextPrimary,
                    letterSpacing = (-0.4).sp,
                    lineHeight = 22.sp
                )

                Box(
                    modifier = Modifier
                        .background(ChatColors.TextSecondary, RoundedCornerShape(3.dp))
                        .padding(horizontal = 3.dp, vertical = 1.dp)
                ) {
                    Text(
                        text = "Ad",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        lineHeight = 13.sp
                    )
                }
            }

            Spacer(modifier = Modifier.height(1.dp))

            Text(
                text = chat.lastMessage,
                fontSize = 14.sp,
                color = ChatColors.TextSecondary,
                letterSpacing = (-0.15).sp,
                lineHeight = 20.sp,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

            Spacer(modifier = Modifier.height(1.dp))

            Text(
                text = "View More",
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = ChatColors.LinkColor,
                letterSpacing = (-0.15).sp,
                lineHeight = 16.sp
            )
        }

        Image(
            painter = painterResource(Res.drawable.ad_pixsellz),
            contentDescription = "Ad image",
            modifier = Modifier
                .size(60.dp)
                .clip(RoundedCornerShape(12.dp))
        )
    }
}

@Composable
fun BottomTabBar(
    selectedTab: Int = 0,
    onTabSelected: (Int) -> Unit = {},
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.fillMaxWidth()) {
        HorizontalDivider(
            color = ChatColors.TabBarLine,
            thickness = 1.dp
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(86.dp)
                .background(ChatColors.TabBarBackground)
                .padding(bottom = 34.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 14.dp, bottom = 34.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                TabItem(
                    isSelected = selectedTab == 0,
                    onClick = { onTabSelected(0) },
                    content = {
                        Image(
                            painter = painterResource(Res.drawable.ic_chats),
                            contentDescription = "Chats",
                            modifier = Modifier.size(24.dp),
                            colorFilter = ColorFilter.tint(ChatColors.TabIconInactive)
                        )
                    }
                )

                TabItem(
                    isSelected = selectedTab == 1,
                    onClick = { onTabSelected(1) },
                    content = {
                        Box {
                            Image(
                                painter = painterResource(Res.drawable.ic_people),
                                contentDescription = "People",
                                modifier = Modifier.size(24.dp),
                                colorFilter = ColorFilter.tint(ChatColors.TabIconInactive)
                            )

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

                TabItem(
                    isSelected = selectedTab == 2,
                    onClick = { onTabSelected(2) },
                    content = {
                        Image(
                            painter = painterResource(Res.drawable.ic_settings),
                            contentDescription = "Settings",
                            modifier = Modifier.size(24.dp),
                            colorFilter = ColorFilter.tint(ChatColors.TabIconInactive)
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

@Composable
fun HomeIndicator(modifier: Modifier = Modifier) {
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

// Main App
@Composable
@Preview
fun App() {
    MaterialTheme {
        var selectedTab by remember { mutableStateOf(0) }

        Column(modifier = Modifier.fillMaxSize()) {
            StatusBar()
            ChatTopBar()
            ChatSearchBar()
            StorySection(stories = MockData.stories)

            LazyColumn(
                modifier = Modifier.weight(1f),
                contentPadding = PaddingValues(bottom = 16.dp)
            ) {
                items(MockData.chats) { chat ->
                    ChatItem(
                        chat = chat,
                        onClick = { /* Handle chat click */ }
                    )
                }

                item {
                    AdItem(
                        chat = MockData.adChat,
                        onClick = { /* Handle ad click */ }
                    )
                }
            }

            BottomTabBar(
                selectedTab = selectedTab,
                onTabSelected = { newTab -> selectedTab = newTab }
            )

            HomeIndicator()
        }
    }
}