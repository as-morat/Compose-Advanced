package com.example.composeadvanced.text

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.selection.DisableSelection
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Create
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
@Preview(showBackground = true)
fun Run() {
    // STATE
    var text by remember { mutableStateOf("") }

    // GRADIENTS
    // Create gradient backgrounds for UI decoration.
    val bgGradient = Brush.linearGradient(
        colors = listOf(Color.White, Color.LightGray)
    )
    val cardGradient = Brush.linearGradient(
        colors = listOf(Color.Red, Color.Blue)
    )

    // --- ROOT CONTAINER ---
    Box(
        modifier = Modifier
            .fillMaxSize()          // Take full screen
            .background(bgGradient) // Apply gradient background
    ) {
        SelectionContainer { // Allows selecting/copying text inside
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(18.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                // --- DISABLE SELECTION ---
                // Inside here, text cannot be copied.
                DisableSelection {
                    // Build styled text with multiple styles in one Text component
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
                                ) { append("hey ") }

                                withStyle(
                                    SpanStyle(
                                        color = Color.Red,
                                        fontSize = 56.sp,
                                        fontWeight = FontWeight.SemiBold,
                                        fontStyle = FontStyle.Italic
                                    )
                                ) { append("A") }

                                append("SH.")
                            }
                        },
                        modifier = Modifier.fillMaxWidth(),
                        fontSize = 32.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.Blue
                    )
                }

                Spacer(Modifier.height(28.dp)) // Empty space

                // --- INPUT FIELD CARD ---
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    OutlinedTextField(
                        value = text,                 // Current text state
                        onValueChange = { text = it },// Updates state when user types
                        label = { Text("Enter text") }, // Label inside input
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth(),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedTextColor = Color(0xFF0F172A),
                            unfocusedTextColor = Color(0xFF0F172A),
                            focusedLabelColor = Color(0xFF2563EB),
                            unfocusedLabelColor = Color(0xFF64748B),
                            cursorColor = Color(0xFF2563EB),
                            focusedBorderColor = Color(0xFF2563EB),
                            unfocusedBorderColor = Color(0xFFCBD5E1),
                            focusedContainerColor = Color.Transparent,
                            unfocusedContainerColor = Color.Transparent
                        ),
                        leadingIcon = {
                            // Icon at the start of input field
                            Icon(
                                Icons.Filled.Create,
                                contentDescription = "edit",
                                tint = Color(0xFF475569)
                            )
                        },
                        trailingIcon = {
                            // CLEAR BUTTON
                            // Shown only when there is text
                            if (text.isNotEmpty()) {
                                IconButton(onClick = { text = "" }) {
                                    Icon(
                                        Icons.Filled.Close,
                                        contentDescription = "clear",
                                        tint = Color(0xFFDC2626)
                                    )
                                }
                            }
                        },
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Text, // Input type
                            imeAction = ImeAction.Done        // Show "Done" on keyboard
                        )
                    )
                }

                Spacer(Modifier.height(22.dp))

                // --- GRADIENT DIVIDER LINE ---
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(6.dp)
                        .clip(RoundedCornerShape(50)) // Rounded edges
                        .background(cardGradient)     // Apply gradient
                )

                Spacer(Modifier.height(22.dp))

                // --- LONG TEXT WITH ELLIPSIS ---
                Text(
                    text = " Welcome to the App world  >> ".repeat(30),
                    maxLines = 16,                        // Show max 16 lines
                    overflow = TextOverflow.Ellipsis,     // Show "..." if overflow
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.Magenta
                )
            }
        }
    }
}