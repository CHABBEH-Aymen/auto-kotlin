package com.example.live_coding_1

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.Telephony
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.live_coding_1.ui.theme.Live_Coding_1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Live_Coding_1Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    HomeScreen(padding = innerPadding, modifier = Modifier.fillMaxSize())
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeScreen(modifier: Modifier = Modifier, padding: PaddingValues = PaddingValues(15.dp))
{
    Column (modifier = modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center)
    {
        Text("Aymen Chabbeh")
        Text("Full Stack Developer")
        UnderLineText(title = "Phone Number: ", text = "+212 612593011")
        UnderLineText(title = "Email: ", text = "chabbehaymen@gmail.com")

            val context = LocalContext.current
        val siteIntent = Intent(Intent.ACTION_VIEW).apply {
            data = Uri.parse("https://www.google.com")
        }
        Button(onClick = { context.startActivity(siteIntent) })
        {
            Text("Visite Mon Site")
        }
    }
}

@Composable
fun UnderLineText(modifier: Modifier = Modifier, title: String, text: String)
{
    Row ()
    {
        Text("$title: ",)
        Text("$text", textDecoration = TextDecoration.Underline)
    }
}

