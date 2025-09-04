package com.example.composeadvanced.state

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
//import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

// -------------------- 1. States & Events --------------------
@Composable
fun StateAndEventExample() {
    // State: a value that changes over time
    var isClicked by remember { mutableStateOf(false) }

        Box(
            modifier = Modifier
                .size(150.dp, 80.dp)
                .shadow(12.dp, RoundedCornerShape(18.dp))
                .background(
                    brush = Brush.linearGradient(
                        if (!isClicked) listOf(Color.Red, Color.Yellow)
                        else listOf(Color.Green, Color.Cyan)
                    ),
                    shape = RoundedCornerShape(18.dp)
                )
                .clickable { isClicked = !isClicked }, // Event triggers state change
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "$isClicked",
                color = Color.White,
                fontWeight = FontWeight.SemiBold,
                fontSize = 24.sp
            )
        }
}

/*
Concepts:
- State: `isClicked` variable holds current state
- Event: `.clickable` updates the state
- Recomposition: only this Box updates when state changes
*/


// -------------------- 2. Stateful & Stateless Composables --------------------

// Stateless: receives state & callback, doesn't manage its own state
@Composable
fun StatelessButton(isClicked: Boolean, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .size(150.dp, 80.dp)
            .shadow(12.dp, RoundedCornerShape(18.dp))
            .background(
                brush = Brush.linearGradient(
                    if (!isClicked) listOf(Color.Magenta, Color.Blue)
                    else listOf(Color.Cyan, Color.Green)
                ),
                shape = RoundedCornerShape(18.dp)
            )
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "$isClicked",
            color = Color.White,
            fontWeight = FontWeight.SemiBold,
            fontSize = 24.sp
        )
    }
}

// Stateful: holds its own state and uses StatelessButton
@Composable
fun StatefulButton() {
    var isClicked by remember { mutableStateOf(false) }
    StatelessButton(isClicked) { isClicked = !isClicked }
}

/*
Concepts:
- Stateless: reusable component, state passed from parent
- Stateful: owns internal state
- Best practice: lift state (hoist) for reusability
*/


// -------------------- 3. State Hoisting --------------------
@Composable
fun HoistedButtons() {
    // Parent state lifted to this composable
    var parentState by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        StatelessButton(isClicked = parentState) {
            parentState = !parentState
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(text = "Parent state: $parentState")
    }
}

/*
Concepts:
- State Hoisting: move state to parent
- Child becomes stateless → easier to reuse
*/


// -------------------- 4. ViewModel - State Holder --------------------
class ButtonViewModel : ViewModel() {
    private val _isClicked = MutableLiveData(false)
    val isClicked: LiveData<Boolean> = _isClicked

    fun toggle() {
        _isClicked.value = !(_isClicked.value ?: false)
    }
}

//@Composable
//fun ButtonWithViewModel(viewModel: ButtonViewModel = viewModel()) {
//    val isClicked by viewModel.isClicked.observeAsState(false)
//    StatelessButton(isClicked) { viewModel.toggle() }
//}

/*
Concepts:
- ViewModel: persists state across config changes
- Compose observes LiveData via `observeAsState()`
- UI just reads state & triggers events
*/


// -------------------- 5. Internal State with Composable --------------------
@Composable
fun InternalStateExample() {
    var count by remember { mutableIntStateOf(0) }

    val color1 = listOf(
        Color.Magenta,
        Color.Green,
        Color.Blue,
        Color.Yellow,
        Color.Cyan,
    )
    val color2 = listOf(
        Color.Yellow,
        Color.Red,
        Color.Cyan,
        Color.Magenta,
        Color.Green,
        Color.Blue,
    )

    Box(
        modifier = Modifier
            .size(150.dp, 80.dp)
            .shadow(12.dp,RoundedCornerShape(18))
            .clip(RoundedCornerShape(18))
            .background(brush = Brush.linearGradient(
                listOf(
                    color1.random(),
                    color2.random()
                )
            ))
            .clickable { count++}, // internal state increment
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = "$count",
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp
        )
    }
}

/*
Concepts:
- Internal state: private to composable
- Only this composable recomposes when state changes
*/
