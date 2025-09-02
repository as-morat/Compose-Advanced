package com.example.composeadvanced.text

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Run(
    normal : String,
    edit : String
) {
    Column (
        modifier = Modifier.fillMaxSize(),
        Arrangement.Center,
        Alignment.CenterHorizontally
    ){
        Text(
            buildAnnotatedString {
                withStyle(
                    SpanStyle(
                        color = Color.DarkGray,
                        fontSize = 32.sp
                    )
                ){
                    append(normal)
                }

                withStyle(
                    SpanStyle(
                        fontSize = 48.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.Red,
                        baselineShift = BaselineShift.Superscript  // used to write superscript
                    )
                ){
                    append(edit)
                }
            }
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            buildAnnotatedString {
                withStyle(
                    SpanStyle(
                        color = Color.DarkGray,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 48.sp
                    )
                ){
                    append(normal)
                }

                withStyle(
                    SpanStyle(
                        fontSize = 32.sp,
                        color = Color.Red,
                        baselineShift = BaselineShift.Subscript  // used to write subscript
                    )
                ){
                    append(edit)
                }
            }
        )
    }
}