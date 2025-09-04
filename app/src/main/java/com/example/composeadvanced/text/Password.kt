package com.example.composeadvanced.image.com.example.composeadvanced.text

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.composeadvanced.R

@Composable
fun RunPass() {
    Column(
        Modifier.fillMaxSize()
            .animateContentSize(
                animationSpec = tween(
                    durationMillis = 50,
                    easing = LinearOutSlowInEasing
                )
            ),
        Arrangement.Center,
        Alignment.CenterHorizontally
    ) {
        var password by remember { mutableStateOf("") }
        var passwordVisibility by remember { mutableStateOf(false) }
        val icon =
            if (passwordVisibility) painterResource(R.drawable.eye)
        else painterResource(R.drawable.hidden)

        OutlinedTextField(
            password,
            {password = it},
            placeholder = {
                Text("Password")
            },
            label = {
                Text("Password")
            },
            trailingIcon = {
                IconButton ({passwordVisibility = !passwordVisibility}){
                    Icon (
                        icon,
                        "Visibility icon",
                        Modifier.size(18.dp)
                    )
                }
            },
            visualTransformation =
                if (passwordVisibility) VisualTransformation.None
            else PasswordVisualTransformation()
        )
    }
}