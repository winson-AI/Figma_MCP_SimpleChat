package com.example.simplechatv2.data

object MockData {
    val chats = listOf(
        Chat(
            id = "1",
            name = "Maximillian Jacobson",
            lastMessage = "Messenger UI · Thu",
            timestamp = "Thu",
            isRead = false,
            avatarUrl = "avatar_joshua.png"
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
            isRead = true
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
            isRead = true
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