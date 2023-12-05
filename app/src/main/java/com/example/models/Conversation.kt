package com.example.models

import com.example.utils.formatDate
import java.util.Date

    data class Conversation(
        val name: String,
        val dateTime: String,
        val isRead: Boolean,
        val lastMessage: String
    )

    val makeConversation = listOf(
        Conversation("Joseph", "${formatDate(Date())}", false, "Salut! comment tu vas ? "),
        Conversation("James", "${formatDate(Date())}", true, "ok ça marche"),
        Conversation("Nassera", "${formatDate(Date())}", true, "bonne journée"),
        Conversation("Mohamed", "${formatDate(Date())}", true, "c'est cool")
    )