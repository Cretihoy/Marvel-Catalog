package me.cretihoy.marvelcompose.ui.theme

import androidx.compose.material.Shapes
import racra.compose.smooth_corner_rect_library.AbsoluteSmoothCornerShape

val Rounded = Shapes(
    small = AbsoluteSmoothCornerShape(roundnessSmall, 100),
    medium = AbsoluteSmoothCornerShape(roundnessMedium, 100),
    large = AbsoluteSmoothCornerShape(roundnessLarge, 100)
)