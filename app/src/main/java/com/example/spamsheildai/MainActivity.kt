package com.example.spamsheildai

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.spamsheildai.model.MessageRequest
import com.example.spamsheildai.model.MessageResponse
import com.example.spamsheildai.network.RetrofitClient
import com.example.spamsheildai.ui.theme.SpamsheildAITheme
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            SpamsheildAITheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SpamCheckerScreen()
                }
            }
        }
    }
}

@Composable
fun SpamCheckerScreen() {
    var message by remember { mutableStateOf("") }
    var result by remember { mutableStateOf<String?>(null) }
    var isLoading by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        OutlinedTextField(
            value = message,
            onValueChange = { message = it },
            label = { Text("Enter your message") },
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = {
                isLoading = true
                checkMessage(message) {
                    result = it
                    isLoading = false
                }
            },
            enabled = message.isNotBlank(),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Check for Spam")
        }

        if (isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(alignment = androidx.compose.ui.Alignment.CenterHorizontally))
        }

        result?.let {
            Text(
                text = it,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.primary
            )
        }
    }
}

fun checkMessage(message: String, onResult: (String?) -> Unit) {
    val request = MessageRequest(message)
    val call = RetrofitClient.apiService.analyzeMessage(request)

    call.enqueue(object : Callback<MessageResponse> {
        override fun onResponse(
            call: Call<MessageResponse>,
            response: Response<MessageResponse>
        ) {
            if (response.isSuccessful) {
                val prediction = response.body()?.prediction
                onResult("Prediction: $prediction")
            } else {
                onResult("Server error: ${response.code()}")
            }
        }

        override fun onFailure(call: Call<MessageResponse>, t: Throwable) {
            onResult("Network error: ${t.message}")
        }
    })
}
