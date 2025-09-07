package com.example.composeadvanced.canvas

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp

@Composable
fun CustomComponent(
    canvaSize: Dp = 300.dp,
    indicatorValue: Int = 0,
    maxIndicatorValue: Int = 100,
    indicatorColor: Color = MaterialTheme.colorScheme.onSurface.copy(0.1f),
    backgroundIndicatorStrokeWidth: Float = 100f,
    foregroundIndicatorColor: Brush = Brush.linearGradient(listOf(Color(0xfff09819), Color(0xffda22FF))),
    foregroundIndicatorStrokeWidth: Float = 100f,
    bigTextColor: Color =  Color(0xfff09879),
    bigTextFontSize: TextUnit = MaterialTheme.typography.displayMedium.fontSize,
    bigTextSuffix: String = "GB",
    smallText: String = "Remaining",
    smallTextColor: Color = MaterialTheme.colorScheme.onSurface,
    smallTextFontSize: TextUnit = MaterialTheme.typography.titleMedium.fontSize
) {
    var allowIndicatorValue by remember {
        mutableIntStateOf(maxIndicatorValue)
    }
    allowIndicatorValue = if (indicatorValue <= maxIndicatorValue){
        indicatorValue
    }
    else{
        maxIndicatorValue
    }

    var animatedIndicatorValue by remember { mutableFloatStateOf(0f) }
    LaunchedEffect(allowIndicatorValue) {
        animatedIndicatorValue = allowIndicatorValue.toFloat()
    }

    val percentage = (animatedIndicatorValue / maxIndicatorValue) * 100
    val sweepAngle by animateFloatAsState(
        targetValue = (2.4 * percentage).toFloat(),
        animationSpec = tween (
            1000
        )
    )

    val animatedTextColor by animateColorAsState(
        targetValue = (if (allowIndicatorValue == 0) {
            MaterialTheme.colorScheme.onSurface
        } else {
            bigTextColor
        }),
        animationSpec = tween (
            1000
        )
    )

    val animatedText by animateIntAsState(
        targetValue = allowIndicatorValue,
        animationSpec = tween (
            1000
        )
    )

    Column(
        modifier = Modifier
            .size(canvaSize)
            .drawBehind {
                val componentSize = Size(
                    width = size.width / 1.25f,
                    height = size.height / 1.25f
                )

                backgroundIndicator(
                    componentSize = componentSize,
                    indicatorColor = indicatorColor,
                    indicatorStrokeWidth = backgroundIndicatorStrokeWidth
                )

                foregroundIndicator(
                    sweepAngle = sweepAngle,
                    componentSize = componentSize,
                    indicatorColor = foregroundIndicatorColor,
                    indicatorStrokeWidth = foregroundIndicatorStrokeWidth
                )
            },
        Arrangement.Center,
        Alignment.CenterHorizontally
    ) {
        EmbeddedElements(
            animatedText,
            bigTextSuffix,
            bigTextFontSize,
            animatedTextColor,
            smallText,
            smallTextColor,
            smallTextFontSize
        )
    }
}

fun DrawScope.backgroundIndicator(
    componentSize: Size,
    indicatorColor: Color,
    indicatorStrokeWidth: Float
) {
    drawArc(
        size = componentSize,
        color = indicatorColor,
        startAngle = 150f,
        sweepAngle = 240f,
        useCenter = false,
        style = Stroke(
            width = indicatorStrokeWidth,
            cap = StrokeCap.Round
        ),
        topLeft = Offset(
            x = (size.width - componentSize.width) / 2f,
            y = (size.height - componentSize.height) / 2f
        )
    )
}

fun DrawScope.foregroundIndicator(
    sweepAngle: Float,
    componentSize: Size,
    indicatorColor: Brush,
    indicatorStrokeWidth: Float
) {
    drawArc(
        size = componentSize,
        brush = indicatorColor,
        startAngle = 150f,
        sweepAngle = sweepAngle,
        useCenter = false,
        style = Stroke(
            width = indicatorStrokeWidth,
            cap = StrokeCap.Round
        ),
        topLeft = Offset(
            x = (size.width - componentSize.width) / 2f,
            y = (size.height - componentSize.height) / 2f
        )
    )
}

@Composable
fun EmbeddedElements(
    bigText: Int,
    bigTextSuffix: String,
    bigTextFontSize: TextUnit,
    bigTextColor: Color,
    smallText: String,
    smallTextColor: Color,
    smallTextFontSize: TextUnit
) {
    Text(
        smallText,
        color = smallTextColor,
        fontSize = smallTextFontSize,
        textAlign = TextAlign.Center
    )
    Text(
        "$bigText ${bigTextSuffix.take(2)}",
        color = bigTextColor,
        fontSize = bigTextFontSize,
        textAlign = TextAlign.Center,
        fontWeight = FontWeight.Bold
    )
}
