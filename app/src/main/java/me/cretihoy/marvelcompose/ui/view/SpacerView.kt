package me.cretihoy.marvelcompose.ui.view

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import me.cretihoy.marvelcompose.ui.theme.spacingMedium

@Composable
fun SpacerView(size: Dp = spacingMedium) {
    Spacer(modifier = Modifier.size(size))
}