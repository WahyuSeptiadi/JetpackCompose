package com.why.jetpack.compose

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import com.why.jetpack.compose.ui.theme.JetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeTheme {
            }
            // A surface container using the 'background' color from the theme
            Surface(color = MaterialTheme.colors.background) {
                InitView()
            }
        }
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun InitView() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var password by remember {
            mutableStateOf("")
        }
        var passVisibility by remember {
            mutableStateOf(false)
        }
        val context = LocalContext.current
        val keyboardController = LocalSoftwareKeyboardController.current

        val icon =
            if (passVisibility)
                painterResource(id = R.drawable.ic_visibility_on)
            else
                painterResource(id = R.drawable.ic_visibility_off)

        // TextField, BasicTextField, OutlineTextField
        OutlinedTextField(
            value = password,
            onValueChange = {
                password = it
            },
            placeholder = {
                Text(text = "Type here...")
            },
            label = {
                Text(text = "Password")
            },
            trailingIcon = {
                IconButton(onClick = {
                    passVisibility = !passVisibility
                }) {
                    Icon(
                        painter = icon,
                        contentDescription = "Check"
                    )
                }
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = {
                    Toast.makeText(context, "done :)", Toast.LENGTH_SHORT).show()
                    keyboardController?.hide()
                }
            ),
            visualTransformation =
            if (passVisibility) VisualTransformation.None
            else PasswordVisualTransformation()
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackComposeTheme {
        InitView()
    }
}