package com.example.multifloatingactionbuttonexample.fab

import android.util.Log
import android.widget.Toast
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.Transition
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp


@Composable
fun  MultiFloatingActionButton(
    fabIcon: androidx.compose.ui.graphics.vector.ImageVector,
    items: List<FabItem>,
    showLabels: Boolean = true,
    onStateChanged: ((state: MultiFabState) -> Unit)? = null
) {
    var currentState by remember { mutableStateOf(MultiFabState.COLLAPSED) }
    val stateTransition: Transition<MultiFabState> = updateTransition(targetState = currentState, label = "")
    // State Change
    val stateChange: () -> Unit = {
        currentState = if (stateTransition.currentState == MultiFabState.EXPANDED) {
            MultiFabState.COLLAPSED
        } else MultiFabState.EXPANDED
        onStateChanged?.invoke(currentState)
    }
    // Fab Rotation Animation
    val rotation: Float by stateTransition.animateFloat(
        transitionSpec = {
            if (targetState == MultiFabState.EXPANDED) {
                spring(stiffness = Spring.StiffnessLow)
            } else {
                spring(stiffness = Spring.StiffnessMedium)
            }
        },
        label = ""
    ) { state ->
        if (state == MultiFabState.EXPANDED) 45f else 0f
    }
 Scaffold {it->
     Column(modifier = Modifier.fillMaxSize().padding(it),
         horizontalAlignment = Alignment.CenterHorizontally,
         verticalArrangement = Arrangement.Center
     ) {
         items.forEach { item ->
             SmallFloatingActionButtonRow(
                 item = item,
                 stateTransition = stateTransition,
                 showLabel = showLabels
             )
             Spacer(modifier = Modifier.height(20.dp))
         }
         FloatingActionButton(onClick = {
             stateChange()

         }) {
             Icon(
                 imageVector = fabIcon,
                 contentDescription = "",
                 modifier = Modifier.rotate(rotation)
             )
         }
     }
 }

}