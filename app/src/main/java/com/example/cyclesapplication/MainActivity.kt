package com.example.cyclesapplication

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.EditText
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layout
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cyclesapplication.ui.theme.CyclesApplicationTheme

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
    var numberValue by mutableStateOf(0)
}

@Composable
fun InputField(state: AppState) {
}

@Composable
fun ResultTextField(state: AppState) {

}


@Composable
fun ProcessDataButton(state: AppState) {

}

@Preview
@Composable
fun MainLayout() {
    val state = remember { AppState() }

    Column(
        modifier = Modifier.padding(16.dp)
    )
    {
        InputField(state);
        ResultTextField(state);
        ProcessDataButton(state);
    }
}