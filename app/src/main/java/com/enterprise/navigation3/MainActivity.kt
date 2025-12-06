package com.enterprise.navigation3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.enterprise.navigation3.navigation.AppNavigation
import com.enterprise.navigation3.ui.theme.Navigation3Theme

class MainActivity : ComponentActivity() {

    //Navigation3 link
    //https://www.youtube.com/watch?v=G_e9XL5tI6U
    //https://github.com/philipplackner/Nav3Guide/tree/1-nav3-basics
    //https://developer.android.com/guide/navigation/navigation-3
    //https://github.com/android/nav3-recipes

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Navigation3Theme {
                Navigation3App()
            }
        }
    }
}

@Composable
fun Navigation3App() {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            AppNavigation()

        }
    }

}