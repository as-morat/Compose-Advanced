package com.example.composeadvanced.lazycolumn

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Run(modifier: Modifier = Modifier) {
    val personRepository = PersonRepo()
    val getAllData = personRepository.getAllData()
    val section = listOf("A","B", "C", "D", "E")

    LazyColumn(
        contentPadding = PaddingValues(12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {

        section.forEach { section ->
            stickyHeader {
                Text(
                    "Section $section",
                    fontSize = 48.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.White,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            brush = Brush.linearGradient(
                                listOf(
                                    Color(0xFF606c88),
                                    Color(0xFF3f4c6b)
                                )
                            ),
                            shape = RoundedCornerShape(bottomEnd = 18.dp, bottomStart = 18.dp)
                        )
                        .padding(12.dp),
                )
            }

            items(items = getAllData) { person ->
                CustomItem(person = person)
            }
        }
    }
}