package com.example.finote.data

data class Transaction(
    val id: Int,
    val title: String,
    val amount: Double,
    val type: String,
    val category: String,
    val date: String
)