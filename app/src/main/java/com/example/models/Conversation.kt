package com.example.models

import java.util.Date

data class Conversation(
    val name: String,
    val dateTime: Date,
    val isRead: Boolean,
    val lastMessage: String
)
val makeConversation = listOf(
    Conversation("Joseph", Date(), false, "i am Joseph"),
    Conversation("James", Date(), true, "I am James"),
    Conversation("Nassera", Date(), true, "I am Nassera"),
    Conversation("Mohamed", Date(), true, "I am Mohamed")

)