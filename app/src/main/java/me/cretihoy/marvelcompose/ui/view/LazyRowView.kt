package me.cretihoy.marvelcompose.ui.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import me.cretihoy.marvelcompose.ui.theme.spacingLarge
import me.cretihoy.marvelcompose.ui.theme.spacingMedium
import me.cretihoy.model.data.model.BaseItem

@Composable
fun LazyRowView(
    title: String,
    items: List<BaseItem>?,
    paddingHorizontal: Dp = spacingLarge,
    bottomPadding: Dp = spacingMedium,
    gap: Dp = spacingMedium,
    onClick: (BaseItem?) -> Unit = {}
) {
    if (items.isNullOrEmpty().not()) {
        Column {
            TitleView(
                text = title,
                modifier = Modifier.padding(horizontal = paddingHorizontal)
            )
            LazyRow {
                item {
                    SpacerView(paddingHorizontal)
                }
                itemsIndexed(items.orEmpty()) { index, item ->
                    ItemView(
                        url = item.getImageOrNull()?.getFullUrl().orEmpty(),
                        text = item.getTitleOrNull().orEmpty(),
                        onClick = {
                            onClick.invoke(item)
                        }
                    )
                    if (index < (items?.lastIndex ?: 0)) SpacerView(gap)
                }
                item {
                    SpacerView(paddingHorizontal)
                }
            }
            SpacerView(bottomPadding)
        }
    }
}

@Composable
@Preview(showBackground = true)
fun PreviewLazyRowView() {
    val items = listOf(
        PreviewFactory.getRandomCharacter(),
        PreviewFactory.getRandomCharacter(),
        PreviewFactory.getRandomCharacter(),
        PreviewFactory.getRandomCharacter(),
        PreviewFactory.getRandomCharacter()
    )
    LazyRowView(title = "Characters", items = items)
}