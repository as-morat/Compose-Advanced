package com.example.composeadvanced.image

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.composeadvanced.R

@Composable
fun Coil(modifier: Modifier = Modifier) {
    var isLoading by remember { mutableStateOf(false) }
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data("https://i.pinimg.com/736x/e3/f2/4d/e3f24dcb2ff024630ac90912e49e3790.jpg")
                .crossfade(1000)
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.error)
                .build()
            ,
            contentDescription = "Logo image",
            modifier = Modifier.size(280.dp),
            onLoading = {isLoading = true},
            onSuccess = {isLoading = false},
            onError = { isLoading = false }
        )

        if (isLoading){
            CircularProgressIndicator(
                modifier = Modifier
                    .size(100.dp)
                    .align(Alignment.Center),
            )
        }
    }
}




