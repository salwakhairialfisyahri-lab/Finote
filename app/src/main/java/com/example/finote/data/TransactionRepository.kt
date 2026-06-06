package com.example.finote.data

import androidx.compose.runtime.mutableStateListOf
import java.time.LocalDate

object TransactionRepository {

    val transactions = mutableStateListOf<Transaction>()

    fun addTransaction(
        title: String,
        amount: Double,
        type: String,
        category: String,
        date: String
    ) {

        val newId =
            if (transactions.isEmpty()) 1
            else transactions.maxOf { it.id } + 1

        transactions.add(
            Transaction(
                id = newId,
                title = title,
                amount = amount,
                type = type,
                category = category,
                date = date
            )
        )
    }

    fun deleteTransaction(id: Int) {
        transactions.removeAll { it.id == id }
    }

    fun updateTransaction(
        id: Int,
        title: String,
        amount: Double,
        type: String,
        category: String,
        date: String
    ) {

        val index =
            transactions.indexOfFirst {
                it.id == id
            }

        if (index != -1) {

            transactions[index] =
                Transaction(
                    id = id,
                    title = title,
                    amount = amount,
                    type = type,
                    category = category,
                    date = date
                )
        }
    }
    fun totalIncome() =
        transactions
            .filter { it.type == "Pemasukan" }
            .sumOf { it.amount }

    fun totalExpense() =
        transactions
            .filter { it.type == "Pengeluaran" }
            .sumOf { it.amount }

    fun balance() =
        totalIncome() - totalExpense()

    fun weeklyIncome(): Double {

        val today = LocalDate.now()

        return transactions
            .filter { it.type == "Pemasukan" }
            .filter {
                val date = LocalDate.parse(it.date)
                !date.isBefore(today.minusDays(7))
            }
            .sumOf { it.amount }
    }

    fun weeklyExpense(): Double {

        val today = LocalDate.now()

        return transactions
            .filter { it.type == "Pengeluaran" }
            .filter {
                val date = LocalDate.parse(it.date)
                !date.isBefore(today.minusDays(7))
            }
            .sumOf { it.amount }
    }

    fun monthlyIncome(): Double {

        val month = LocalDate.now().monthValue
        val year = LocalDate.now().year

        return transactions
            .filter {
                val d = LocalDate.parse(it.date)

                it.type == "Pemasukan" &&
                        d.monthValue == month &&
                        d.year == year
            }
            .sumOf { it.amount }
    }

    fun monthlyExpense(): Double {

        val month = LocalDate.now().monthValue
        val year = LocalDate.now().year

        return transactions
            .filter {
                val d = LocalDate.parse(it.date)

                it.type == "Pengeluaran" &&
                        d.monthValue == month &&
                        d.year == year
            }
            .sumOf { it.amount }
    }

}