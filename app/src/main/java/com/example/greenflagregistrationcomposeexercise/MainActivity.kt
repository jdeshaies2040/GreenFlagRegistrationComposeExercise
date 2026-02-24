package com.example.greenflagregistrationcomposeexercise

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.greenflagregistrationcomposeexercise.ui.theme.GreenFlagRegistrationComposeExerciseTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GreenFlagRegistrationComposeExerciseTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    containerColor = Color.Black
                ) { innerPadding ->
                    MyScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MyScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Image Header
        Image(
            painter = painterResource(id = R.drawable.logo_green_flag),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .padding(top = 32.dp)
                .padding(horizontal = 16.dp),
            contentScale = ContentScale.Fit
        )

        // Center Content - Using weight(1f) ensures the list fills the middle
        MyLazyColumn(modifier = Modifier.weight(1f))

        // Your custom button at the bottom
        ImageBackgroundButton(
            onClick = { /* Handle click here */ },
            buttonText = "Create an account",
            modifier = Modifier.padding(bottom = 24.dp)
        )
    }
}

@Composable
fun MyLazyColumn(modifier: Modifier = Modifier) {
    val items = listOf(
        "Car health updates",
        "Request a rescue online",
        "Policy information"
    )

    // Box centers the entire content horizontally and vertically
    Box(
        modifier = modifier.fillMaxWidth().padding(horizontal = 16.dp),
        contentAlignment = Alignment.Center
    ) {
        LazyColumn(
            modifier = Modifier.wrapContentWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start // Keeps the header and items left-aligned relative to each other
        ) {
            item {
                Text(
                    text = "GreenFlag customers can\ncreate an account to access",
                    color = Color.White,
                    fontSize = 24.sp,
                    textAlign = TextAlign.Start, // Left-justified text
                    modifier = Modifier.padding(bottom = 8.dp)
                )
            }
            items(items.size) { index ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .padding(vertical = 4.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.tick),
                        contentDescription = null,
                        modifier = Modifier
                            .size(24.dp)
                            .padding(end = 12.dp)
                    )
                    Text(
                        text = items[index],
                        color = Color.White,
                        fontSize = 18.sp
                    )
                }
            }
        }
    }
}

@Composable
fun ImageBackgroundButton(
    onClick: () -> Unit,
    buttonText: String,
    modifier: Modifier = Modifier
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier.fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = R.drawable.gradient_button_background),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.fillMaxWidth().height(70.dp)
        )

        Button(
            onClick = onClick,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent,
                contentColor = Color.Black
            ),
            modifier = Modifier.fillMaxWidth().height(70.dp)
        ) {
            Text(
                text = buttonText,
                fontSize = 24.sp
            )
        }
    }
}
