package com.example.simplechatv2.data

data class Chat(
    val id: String,
    val name: String,
    val lastMessage: String,
    val timestamp: String,
    val isRead: Boolean = false,
    val avatarUrl: String? = null
)

data class User(
    val id: String,
    val name: String,
    val avatarUrl: String? = null,
    val isOnline: Boolean = false,
    val lastSeen: String? = null
)

data class Story(
    val id: String,
    val userName: String,
    val isYourStory: Boolean = false,
    val avatarUrl: String? = null
)