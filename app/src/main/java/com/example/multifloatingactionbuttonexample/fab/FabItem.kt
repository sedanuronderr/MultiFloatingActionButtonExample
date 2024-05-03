package com.example.multifloatingactionbuttonexample.fab

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector

class FabItem(
    val icon: ImageVector,
    val label: String,
    val onFabItemClicked:   ()-> Unit
)