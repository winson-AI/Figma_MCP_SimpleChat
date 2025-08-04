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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.simplechatv2.ui.theme.ChatColors
import org.jetbrains.compose.resources.painterResource
import simplechatv2.composeapp.generated.resources.Res
import simplechatv2.composeapp.generated.resources.ic_search

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
                .background(
                    ChatColors.SearchBackground,
                    RoundedCornerShape(10.dp)
                )
                .padding(start = 8.dp, end = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            // Search icon
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