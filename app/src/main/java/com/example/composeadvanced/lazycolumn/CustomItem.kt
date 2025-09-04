package com.example.composeadvanced.lazycolumn

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CustomItem(person: Person) {
    Row(
        modifier = Modifier
            .background(
                brush = Brush.linearGradient(
                    listOf(
                        Color(0xFF556270),
                        Color(0xFFFF6B6B)
                    )
                ),
                shape = RoundedCornerShape(18.dp)
            )
            .fillMaxWidth()
            .padding(24.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            text = "${person.age}",
            color = Color.White,
            fontSize = 48.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = person.firstName,
            color = Color.White,
            fontSize = 28.sp,
            fontWeight = FontWeight.Normal
        )
        Text(
            text = person.lastName,
            color = Color.White,
            fontSize = 28.sp,
            fontWeight = FontWeight.Normal
        )
    }
}


@Composable
@Preview
fun CustomItemPreview() {
    CustomItem(
        person = Person(
            id = 0,
            firstName = "John",
            lastName = "Doe",
            age = 20
        )
    )
}