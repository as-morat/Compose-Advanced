package com.example.composeadvanced.searchbar

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ModernSearchScreen() {

    var text by remember { mutableStateOf("") }
    var active by remember { mutableStateOf(false) }
    val items = remember {
        mutableStateListOf(
            "Captain Monkey D. Luffy",
            "Swordsman Roronoa Zoro",
            "Navigator Nami",
            "Cook Sanji",
            "Doctor Tony Tony Chopper",
            "Archaeologist Nico Robin"
        )
    }

    Scaffold { innerPadding ->
        SearchBar(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp),
            inputField = {
                SearchBarDefaults.InputField(
                    query = text,
                    onQueryChange = { text = it },
                    onSearch = {
                        items.add(text)
                        active = false
                        text = ""
                    },
                    expanded = active,
                    onExpandedChange = { active = it },
                    placeholder = {
                        Text(
                            "Search...",
                            color = MaterialTheme.colorScheme.onSurface
                        )
                    },
                    leadingIcon = {
                        Icon(Icons.Default.Search, contentDescription = "search icon")
                    },
                    trailingIcon = {
                        if (active) {
                            Icon(
                                Icons.Default.Close,
                                contentDescription = "close icon",
                                modifier = Modifier.clickable {
                                    if (text.isNotEmpty())
                                        text = ""
                                    else active = false
                                }
                            )
                        }
                    }
                )
            },
            expanded = active,
            onExpandedChange = { active = it }
        ) {
            items.forEach {
                Row(Modifier.padding(14.dp)) {
                    Icon(
                        Icons.Filled.History,
                        "history icon",
                        Modifier.padding(end = 10.dp)
                    )
                    Text(it)
                }
            }
        }
    }
}
