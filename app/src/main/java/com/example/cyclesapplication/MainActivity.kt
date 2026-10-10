package com.example.cyclesapplication

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
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layout
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cyclesapplication.ui.theme.CyclesApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CyclesApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { _ ->
                    MainLayout();
                }
            }
        }
    }
}

@Composable
fun InputField() {
}

@Composable
fun ResultTextField() {
}


@Composable
fun ProcessDataButton() {

}

@Preview
@Composable
fun MainLayout() {
    Column(
        modifier = Modifier.padding(16.dp)
    )
    {
        InputField();
        ResultTextField();
        ProcessDataButton();
    }
}