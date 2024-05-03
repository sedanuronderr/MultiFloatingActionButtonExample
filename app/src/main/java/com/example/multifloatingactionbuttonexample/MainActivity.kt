package com.example.multifloatingactionbuttonexample

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.multifloatingactionbuttonexample.fab.FabItem
import com.example.multifloatingactionbuttonexample.fab.MultiFloatingActionButton
import com.example.multifloatingactionbuttonexample.ui.theme.MultiFloatingActionButtonExampleTheme
import java.security.AccessController.getContext

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MultiFloatingActionButtonExampleTheme {

                    SpeedDial()

            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}
@Composable
fun SpeedDial() {


    val fabItems = listOf(
        FabItem(
            Icons.Filled.ShoppingCart,
            "Shopping Cart",




        ){

         } ,
        FabItem(
            Icons.Filled.Favorite,
            "Favorite"
        ) { /*TODO*/ }
    )
    MultiFloatingActionButton(
        fabIcon = Icons.Filled.Add,
        items = fabItems,
        showLabels = true
    )
}

@Composable
fun showToastMessage(key:String) {
    Toast.makeText(
         LocalContext.current /* Provide your context here */,
        key,
         Toast.LENGTH_SHORT
    ).show()
}









@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MultiFloatingActionButtonExampleTheme {
        SpeedDial()
    }
}