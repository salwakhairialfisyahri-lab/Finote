package com.example.finote.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.finote.data.Transaction
import com.example.finote.data.TransactionRepository

@Composable
fun EditTransactionScreen(
    transaction: Transaction,
    onBack: () -> Unit
) {

    var title by remember {
        mutableStateOf(transaction.title)
    }

    var amount by remember {
        mutableStateOf(transaction.amount.toString())
    }

    var type by remember {
        mutableStateOf(transaction.type)
    }

    var category by remember {
        mutableStateOf(transaction.category)
    }

    var date by remember {
        mutableStateOf(transaction.date)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text(
            text = "Edit Transaksi",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = title,
            onValueChange = { title = it },
            label = { Text("Judul") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(12.dp))

        OutlinedTextField(
            value = amount,
            onValueChange = { amount = it },
            label = { Text("Nominal") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(12.dp))

        OutlinedTextField(
            value = category,
            onValueChange = { category = it },
            label = { Text("Kategori") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(12.dp))

        OutlinedTextField(
            value = date,
            onValueChange = { date = it },
            label = { Text("Tanggal (yyyy-MM-dd)") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(12.dp))

        Button(
            onClick = { type = "Pemasukan" }
        ) {
            Text("Pemasukan")
        }

        Spacer(modifier = Modifier.height(8.dp))

        Button(
            onClick = { type = "Pengeluaran" }
        ) {
            Text("Pengeluaran")
        }

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {

                TransactionRepository.updateTransaction(
                    id = transaction.id,
                    title = title,
                    amount = amount.toDoubleOrNull() ?: 0.0,
                    type = type,
                    category = category,
                    date = date
                )

                onBack()
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Update")
        }
    }
}