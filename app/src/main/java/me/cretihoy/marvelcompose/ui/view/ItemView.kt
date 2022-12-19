package me.cretihoy.marvelcompose.ui.view

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import coil.request.ImageRequest
import me.cretihoy.marvelcompose.ui.theme.EMPTY_STRING
import me.cretihoy.marvelcompose.ui.theme.Rounded
import me.cretihoy.marvelcompose.ui.theme.spacingMedium

@Composable
fun ItemView(
    modifier: Modifier = Modifier,
    text: String? = null,
    url: String? = null,
    onClick: () -> Unit = {}
) {
    Column(
        modifier = modifier
            .clip(shape = Rounded.large)
            .clickable { onClick.invoke() }
    ) {
        url?.let {
            AsyncImage(
                modifier = Modifier.fillMaxWidth(),
                model = ImageRequest.Builder(LocalContext.current)
                    .placeholder(PreviewFactory.getRandomImageRes())
                    .data(url)
                    .crossfade(true)
                    .build(),
                contentDescription = EMPTY_STRING,
                contentScale = ContentScale.Crop
            )
        }
        text?.let {
            Box(
                modifier = Modifier
                    .background(colors.onBackground)
                    .padding(spacingMedium)
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = text,
                    color = colors.background
                )
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun PreviewItemView() {
    ItemView(
        url = EMPTY_STRING,
        text = "Item View Example"
    )
}