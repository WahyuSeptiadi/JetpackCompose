package com.why.jetpack.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import com.why.jetpack.compose.ui.theme.JetpackComposeTheme
import com.why.jetpack.compose.ui.theme.Purple200
import com.why.jetpack.compose.ui.theme.Teal200

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeTheme {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    GradientButton(
                        text = "GradientBtn",
                        textColor = Color.White,
                        gradient = Brush.horizontalGradient(
                            colors = listOf(
                                Purple200,
                                Teal200
                            )
                        )
                    ) {}
                    // simple button example
//                    Button(onClick = { onBackPressed() }) {
//                        Text(text = "SimpleBtn")
//                    }
                }
            }
        }
    }
}