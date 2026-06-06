package com.example.finote

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.finote.data.TransactionRepository
import com.example.finote.screen.AddTransactionScreen
import com.example.finote.screen.LoginScreen
import com.example.finote.ui.theme.FinoteTheme
import com.example.finote.screen.EditTransactionScreen
import com.example.finote.data.Transaction

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            FinoteTheme {

                var isLoggedIn by remember {
                    mutableStateOf(false)
                }

                var showAddScreen by remember {
                    mutableStateOf(false)
                }
                var selectedTransaction by remember {
                    mutableStateOf<Transaction?>(null)
                }

                when {

                    !isLoggedIn -> {

                        LoginScreen(
                            onLoginSuccess = {
                                isLoggedIn = true
                            }
                        )
                    }

                    showAddScreen -> {

                        AddTransactionScreen(
                            onBack = {
                                showAddScreen = false
                            }
                        )
                    }

                    else -> {

                        FinoteDashboard(
                            onAddClick = {
                                showAddScreen = true
                            }
                        )
                    }

                }
            }
        }
    }
}

@Composable
fun FinoteDashboard(
    onAddClick: () -> Unit
) {

    val transactions = TransactionRepository.transactions

    val income = TransactionRepository.totalIncome()
    val expense = TransactionRepository.totalExpense()
    val balance = TransactionRepository.balance()

    val weeklyIncome = TransactionRepository.weeklyIncome()
    val weeklyExpense = TransactionRepository.weeklyExpense()

    val monthlyIncome = TransactionRepository.monthlyIncome()
    val monthlyExpense = TransactionRepository.monthlyExpense()

    Scaffold(

        floatingActionButton = {

            FloatingActionButton(
                onClick = onAddClick,
                containerColor = Color(0xFF10B981)
            ) {

                Text(
                    text = "+",
                    color = Color.White,
                    fontSize = 24.sp
                )
            }
        }

    ) { paddingValues ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
        ) {

            Text(
                text = "Finote",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "Kelola Keuanganmu dengan Mudah",
                color = Color.Gray
            )

            Spacer(modifier = Modifier.height(20.dp))

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFF10B981)
                )
            ) {

                Column(
                    modifier = Modifier.padding(20.dp)
                ) {

                    Text(
                        text = "Total Saldo",
                        color = Color.White
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = "Rp ${balance.toInt()}",
                        color = Color.White,
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {

                Card(
                    modifier = Modifier.weight(1f)
                ) {

                    Column(
                        modifier = Modifier.padding(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        Text(
                            text = "💰",
                            fontSize = 28.sp
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        Text("Pemasukan")

                        Text(
                            text = "Rp ${income.toInt()}",
                            fontWeight = FontWeight.Bold
                        )
                    }
                }

                Card(
                    modifier = Modifier.weight(1f)
                ) {

                    Column(
                        modifier = Modifier.padding(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        Text(
                            text = "💸",
                            fontSize = 28.sp
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        Text("Pengeluaran")

                        Text(
                            text = "Rp ${expense.toInt()}",
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Card(
                modifier = Modifier.fillMaxWidth()
            ) {

                Column(
                    modifier = Modifier.padding(16.dp)
                ) {

                    Text(
                        text = "📅 Statistik Mingguan",
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = "Pemasukan : Rp ${weeklyIncome.toInt()}"
                    )

                    Text(
                        text = "Pengeluaran : Rp ${weeklyExpense.toInt()}"
                    )
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            Card(
                modifier = Modifier.fillMaxWidth()
            ) {

                Column(
                    modifier = Modifier.padding(16.dp)
                ) {

                    Text(
                        text = "📊 Statistik Bulanan",
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = "Pemasukan : Rp ${monthlyIncome.toInt()}"
                    )

                    Text(
                        text = "Pengeluaran : Rp ${monthlyExpense.toInt()}"
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Riwayat Transaksi",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )

            Spacer(modifier = Modifier.height(12.dp))

            if (transactions.isEmpty()) {

                Card(
                    modifier = Modifier.fillMaxWidth()
                ) {

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(24.dp),
                        contentAlignment = Alignment.Center
                    ) {

                        Text(
                            text = "Belum ada transaksi"
                        )
                    }
                }

            } else {

                transactions.forEach { transaction ->

                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                    ) {

                        Column(
                            modifier = Modifier.padding(16.dp)
                        ) {

                            Text(
                                text = transaction.title,
                                fontWeight = FontWeight.Bold
                            )

                            Text(
                                text = "Rp ${transaction.amount.toInt()}"
                            )

                            Text(
                                text = transaction.type
                            )

                            Text(
                                text = transaction.category,
                                color = Color.Gray
                            )

                            Text(
                                text = transaction.date,
                                color = Color.Gray
                            )

                            Spacer(modifier = Modifier.height(8.dp))

                            Button(
                                onClick = {
                                    TransactionRepository.deleteTransaction(
                                        transaction.id
                                    )
                                }
                            ) {
                                Text("Hapus")
                            }
                        }
                    }
                }
            }
        }
    }
}