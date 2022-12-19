package me.cretihoy.marvelcompose.ui.view

import androidx.compose.foundation.border
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import me.cretihoy.marvelcompose.ui.theme.EMPTY_STRING
import me.cretihoy.marvelcompose.ui.theme.Rounded
import me.cretihoy.marvelcompose.ui.theme.borderSize

@Composable
fun TextFieldView(
    modifier: Modifier = Modifier,
    text: MutableState<String> = mutableStateOf(EMPTY_STRING)
) {
    TextField(
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = colors.background,
            textColor = colors.onBackground
        ),
        modifier = modifier
            .border(
                borderSize,
                colors.onBackground,
                Rounded.medium
            )
            .clip(Rounded.medium),
        value = text.value,
        onValueChange = { text.value = it }
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewTextFieldView() {
    val text = mutableStateOf(PreviewFactory.getRandomName())
    TextFieldView(text = text)
}