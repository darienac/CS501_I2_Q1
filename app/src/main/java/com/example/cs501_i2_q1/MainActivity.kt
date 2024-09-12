package com.example.cs501_i2_q1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cs501_i2_q1.ui.theme.CS501_I2_Q1Theme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CS501_I2_Q1Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainLayout(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable fun MainLayout(modifier: Modifier = Modifier) {
    var randomIndex by remember { mutableStateOf(Random.nextInt(5)) }
    val quotes = arrayOf(
        "Live long and prosper. - Spock",
        "Do or do not, there is no try. - Yoda",
        "Life is like a box of chocolates. You never know what you're going to get. - Forest Gump",
        "I have a bad feeling about this. - Han Solo",
        "The ability to speak does not make you intelligent. - Qui-Gon Jinn"
    )
    Column(modifier = modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(modifier = Modifier.height(20.dp))
        Quote(
            text = quotes[randomIndex]
        )
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = {randomIndex = (randomIndex + Random.nextInt(4) + 1) % 5}) { // math to avoid repeating a quote
            Text(text = "New Random Quote")
        }
    }
}

@Composable
fun Quote(text: String) {
    Text(
        text = text,
        fontSize = 16.sp,
        color = Color.hsl(120f, 0.5f, 0.4f),
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center
    )
}

@Preview(showBackground = true)
@Composable
fun AppPreview() {
    CS501_I2_Q1Theme {
        MainLayout()
    }
}