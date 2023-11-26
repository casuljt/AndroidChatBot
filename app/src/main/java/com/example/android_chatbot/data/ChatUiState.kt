package com.example.android_chatbot.data

data class ChatUiState (
    //the history chat
    val historyChat: MutableSet<String> = mutableSetOf()
)