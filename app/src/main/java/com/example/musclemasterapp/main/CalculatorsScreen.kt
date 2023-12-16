package com.example.musclemasterapp.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.musclemasterapp.AppViewModel

@Composable
fun CalculatorsScreen(navController: NavController, vm: AppViewModel) {
    Surface {
        Column(modifier = Modifier.fillMaxSize()) {
            Column(modifier = Modifier.weight(1f)) {
                Text(text = "Calc Screen")
            }

            BottomNavigationMenu(selectedItem = BottomNavigationItem.CALCULATORS, navController = navController)
        }
    }
}