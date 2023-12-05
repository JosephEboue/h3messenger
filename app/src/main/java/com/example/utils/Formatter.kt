package com.example.utils

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

fun formatDate(date: Date): String {
    val dateFormat = SimpleDateFormat("dd-MM-yyyy HH:mm")
    return dateFormat.format(date)
}