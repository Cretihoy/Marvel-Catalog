package me.cretihoy.marvelcompose.ui.view

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import me.cretihoy.marvelcompose.R
import me.cretihoy.marvelcompose.ui.theme.EMPTY_STRING
import me.cretihoy.marvelcompose.ui.theme.Rounded
import me.cretihoy.marvelcompose.ui.theme.iconButtonSize

@Composable
fun IconButtonView(
    iconRes: Int? = null,
    modifier: Modifier = Modifier,
    text: String? = null,
    backgroundColor: Color = colors.onBackground,
    contentColor: Color = colors.background,
    action: () -> Unit = {}
) {
    Button(
        modifier = Modifier
            .size(iconButtonSize),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = backgroundColor,
            contentColor = contentColor
        ),
        onClick = action,
        shape = Rounded.medium
    ) {
        Icon(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(iconRes ?: 0),
            contentDescription = EMPTY_STRING
        )
    }
}

@Composable
@Preview(showBackground = true)
fun PreviewIconButtonView() {
    IconButtonView(iconRes = R.drawable.ic_character)
}