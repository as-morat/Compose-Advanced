package com.example.composeadvanced.text

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.composeadvanced.R

@Composable
fun RunPass() {

    var password by remember { mutableStateOf("") }
    val minLength = 8
    var errorMessage by remember { mutableStateOf("") }
    var passwordVisibility by remember { mutableStateOf(false) }

    val icon = if (passwordVisibility) {
        painterResource(R.drawable.eye)
    } else {
        painterResource(R.drawable.hidden)
    }

    Column(
        Modifier
            .fillMaxSize()
            .animateContentSize(
                animationSpec = tween(
                    durationMillis = 50,
                    easing = LinearOutSlowInEasing
                )
            ),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = password,
            onValueChange = {
                password = it
            },
            modifier= Modifier
                .fillMaxWidth().
                padding(start = 48.dp, end = 48.dp)
            ,
            isError = errorMessage.isNotEmpty(),
            placeholder = { Text("Password") },
            label = { Text("Password") },
            singleLine = true,
            trailingIcon = {
                IconButton(onClick = { passwordVisibility = !passwordVisibility }) {
                    Icon(
                        painter = icon,
                        contentDescription = "Visibility icon",
                        modifier = Modifier.size(18.dp)
                    )
                }
            },
            visualTransformation = if (passwordVisibility) {
                VisualTransformation.None
            } else {
                PasswordVisualTransformation()
            }
        )
        if (errorMessage.isNotEmpty()) {
            Spacer(Modifier.height(8.dp))
            Text(errorMessage,
                color = Color.Red
            )
        }

        Spacer(Modifier.height(18.dp))
        Button(onClick = {
            errorMessage = if (password.length < minLength || password.isEmpty()) {
                "Password must be at least $minLength characters"
            } else {
                ""
            }
        }) {
            Text("Submit")
        }
    }
}
