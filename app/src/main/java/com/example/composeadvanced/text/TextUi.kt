package com.example.composeadvanced.text

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.selection.DisableSelection
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
@Preview(showBackground = true)
fun Run() {

    SelectionContainer { // text select for copy
        Column(Modifier.padding(12.dp)) {
            DisableSelection { // can't select text for this part
                Text(
                    buildAnnotatedString {

                        withStyle(ParagraphStyle(textAlign = TextAlign.Center)) {

                            withStyle(
                                SpanStyle(
                                    color = Color.LightGray,
                                    fontSize = 32.sp,
                                    fontWeight = FontWeight.SemiBold,
                                    fontStyle = FontStyle.Italic
                                )
                            ) {
                                append("hey ")
                            }

                            withStyle(
                                SpanStyle(
                                    color = Color.Red,
                                    fontSize = 56.sp,
                                    fontWeight = FontWeight.SemiBold,
                                    fontStyle = FontStyle.Italic
                                )
                            ) {
                                append("A")
                            }

                            append("SH.")
                        }
                    },

                    modifier = Modifier.fillMaxWidth(),
                    color = Color.Blue,
                    fontSize = 32.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }
            Spacer(modifier = Modifier.height(28.dp))

            Text(
                " Welcome to the App world  >> "
                    .repeat(30),
                maxLines = 16,
                overflow = TextOverflow.Ellipsis,
                color = Color.Magenta,
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}