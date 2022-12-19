package me.cretihoy.marvelcompose.ui.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import me.cretihoy.marvelcompose.ui.theme.spacingLarge

@Composable
fun ParagraphView(
    text: String,
    description: String?,
    modifier: Modifier = Modifier,
) {
    if (description.isNullOrEmpty().not()) {
        Column(
            modifier = Modifier.padding(horizontal = spacingLarge)
        ) {
            TitleView(
                text = text
            )
            Text(
                text = description.orEmpty(),
                textAlign = TextAlign.Justify
            )
            SpacerView()
        }
    }
}

