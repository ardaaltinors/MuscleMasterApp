package com.example.musclemasterapp.main

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.example.musclemasterapp.AppViewModel
import com.example.musclemasterapp.DestinationScreen

@Composable
fun NotificationMessage(vm: AppViewModel) {
    val notifState = vm.popupNotification.value
    val notifMessage = notifState?.getContentOrNull()
    if (notifMessage != null) {
        Toast.makeText(LocalContext.current, notifMessage, Toast.LENGTH_LONG).show()
    }
}

fun navigateTo(navContoller: NavController, dest: DestinationScreen) {
    navContoller.navigate(dest.route) {
        popUpTo(dest.route) // backstack ten siler
        launchSingleTop = true
    }
}