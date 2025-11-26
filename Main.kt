package com.example.task5 // MAKE SURE TO KEEP YOUR OWN PACKAGE NAME HERE

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.* // Using Material3
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ThreeCountersScreen()
                }
            }
        }
    }
}

// STEP 3: The Main Screen holding three independent counters
@Composable
fun ThreeCountersScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(24.dp) // Space between the counter rows
    ) {
        Text(
            text = "Multi-Counter App",
            style = MaterialTheme.typography.headlineMedium
        )

        HorizontalDivider()

        // Adding the three independent counters
        CounterRow(label = "Counter 1")
        CounterRow(label = "Counter 2")
        CounterRow(label = "Counter 3")
    }
}

// STEP 1 & 2: A reusable component containing buttons and an editable text field
@Composable
fun CounterRow(label: String) {
    // We use a String state so the user can type into it.
    // We parse it to an Int when doing math.
    var textValue by remember { mutableStateOf("0") }

    Column(horizontalAlignment = Alignment.CenterHorizontally) {

        Text(text = label, fontWeight = FontWeight.Bold, modifier = Modifier.padding(bottom = 8.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            // Button: Decrease
            Button(onClick = {
                val current = textValue.toIntOrNull() ?: 0
                textValue = (current - 1).toString()
            }) {
                Text("-")
            }

            // Text Field: Input starting value or view current count
            OutlinedTextField(
                value = textValue,
                onValueChange = { newValue ->
                    // Validation: Only allow digits and negative sign
                    if (newValue.isEmpty() || newValue.matches(Regex("^-?\\d*$"))) {
                        textValue = newValue
                    }
                },
                modifier = Modifier.width(100.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                singleLine = true,
                maxLines = 1,
                textStyle = LocalTextStyle.current.copy(textAlign = androidx.compose.ui.text.style.TextAlign.Center)
            )

            // Button: Increase
            Button(onClick = {
                val current = textValue.toIntOrNull() ?: 0
                textValue = (current + 1).toString()
            }) {
                Text("+")
            }
        }
    }
}
