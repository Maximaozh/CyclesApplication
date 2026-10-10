package com.example.cyclesapplication

import android.R
import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.EditText
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layout
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cyclesapplication.ui.theme.CyclesApplicationTheme
import java.math.BigInteger

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CyclesApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainLayout();
                }
            }
        }
    }
}
class AppState {
    var inputText by mutableStateOf("")
    var resultText by mutableStateOf("")
}

@Composable
fun InputField(state: AppState) {
    OutlinedTextField(
        value = state.inputText,

        onValueChange = { newText ->
            if (newText.all { it.isDigit() } || newText.isEmpty()) {
                state.inputText = newText
            }
        },

        label = { Text("Введите число") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        modifier = Modifier.padding(bottom = 8.dp)
    )
}

@Composable
fun ResultTextField(state: AppState) {
    OutlinedTextField(
        value = state.resultText,
        onValueChange = { },
        readOnly = true,
        label = { Text("Результат") },
        modifier = Modifier.padding(bottom = 8.dp)
    )
}


@Composable
fun ProcessDataButton(state: AppState) {
    Button(
        onClick = { OnProccessDataButton(state) }
    ) {
        Text("Обработать")
    }
}

fun OnProccessDataButton(state: AppState)
{
    var n = state.inputText.toInt();
    if (n == 0)
    {
        state.resultText = "Н оказался 0"
        return;
    }

    if (n > 20) {
        state.resultText = "Н слишком большое"
        return
    }


    var factorial: Long = 1; // Для расчёта факториала
    for (i in 2..n)
    {
        factorial = factorial * i;
    }


    var k: Long = 1
    while (true) {
        val product = k * (k + 1) * (k + 2)
        if (product == factorial) {
            state.resultText = "$factorial ($k, ${k+1}, ${k+2})"
            return
        }
        if (product > factorial) {
            state.resultText = "$factorial (нет тройки)"
            return
        }
        k++
    }
}

@Preview
@Composable
fun MainLayout() {
    val state = remember { AppState() }

    Column(
        modifier = Modifier.padding(16.dp).fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        InputField(state);
        ResultTextField(state);
        ProcessDataButton(state);
    }
}