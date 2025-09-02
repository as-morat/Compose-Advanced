package com.example.composeadvanced.state

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun Run(modifier: Modifier = Modifier) {
    Column(modifier = Modifier.fillMaxSize().padding(50.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        StateAndEventExample()
//                    Spacer(modifier = Modifier.height(20.dp))
//                    StatelessButton(false) { true }
        Spacer(modifier = Modifier.height(20.dp))
        StatefulButton()
        Spacer(modifier = Modifier.height(20.dp))
        ButtonWithViewModel()
        Spacer(modifier = Modifier.height(20.dp))
        InternalStateExample()
        Spacer(modifier = Modifier.height(20.dp))
        HoistedButtons()
    }
}