package com.example.finote.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.finote.data.TransactionRepository

@Composable
fun AddTransactionScreen(
    onBack: () -> Unit
) {

    var title by remember { mutableStateOf("") }
    var amount by remember { mutableStateOf("") }
    var type by remember { mutableStateOf("Pemasukan") }

    var category by remember {
        mutableStateOf("Makanan")
    }

    var date by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text(
            text = "Tambah Transaksi",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = title,
            onValueChange = {
                title = it
            },
            label = {
                Text("Judul")
            },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(12.dp))

        OutlinedTextField(
            value = amount,
            onValueChange = {
                amount = it
            },
            label = {
                Text("Nominal")
            },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(12.dp))

        OutlinedTextField(
            value = category,
            onValueChange = {
                category = it
            },
            label = {
                Text("Kategori")
            },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(12.dp))

        OutlinedTextField(
            value = date,
            onValueChange = {
                date = it
            },
            label = {
                Text("Tanggal (yyyy-MM-dd)")
            },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(12.dp))

        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {

            Button(
                onClick = {
                    type = "Pemasukan"
                }
            ) {
                Text("Pemasukan")
            }

            Button(
                onClick = {
                    type = "Pengeluaran"
                }
            ) {
                Text("Pengeluaran")
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {

                if (
                    title.isNotEmpty() &&
                    amount.isNotEmpty() &&
                    date.isNotEmpty()
                ) {

                    TransactionRepository.addTransaction(
                        title = title,
                        amount = amount.toDouble(),
                        type = type,
                        category = category,
                        date = date
                    )

                    onBack()
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Simpan")
        }
    }
}