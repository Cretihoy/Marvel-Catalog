package me.cretihoy.marvelcompose.ui.view

import androidx.compose.foundation.layout.sizeIn
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import me.cretihoy.marvelcompose.ui.theme.Rounded
import me.cretihoy.marvelcompose.ui.theme.buttonMinSize

@Composable
fun ButtonView(
    modifier: Modifier = Modifier,
    text: String? = null,
    backgroundColor: Color = colors.onBackground,
    contentColor: Color = colors.background,
    action: () -> Unit = {}
) {
    Button(
        colors = ButtonDefaults.buttonColors(
            backgroundColor = backgroundColor,
            contentColor = contentColor
        ),
        onClick = action,
        shape = Rounded.medium,
        modifier = modifier
            .sizeIn(minHeight = buttonMinSize, minWidth = buttonMinSize)
    ) {
        text?.let {
            Text(
                text = text,
                color = colors.background
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun PreviewButtonView() {
    ButtonView(text = "Button Example")
}