package com.example.musclemasterapp.main

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
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

@Composable
fun CommonProgressSpinner() {
    Row(
        modifier = Modifier
            .alpha(0.5f)
            .background(Color.LightGray)
            .clickable(enabled = false) {}
            .fillMaxSize(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically

    ) {
        CircularProgressIndicator()
    }
}

@Composable
fun checkSignedIn(vm: AppViewModel, navContoller: NavController) {
    val alreadyLoggedIn = remember { mutableStateOf(false) }
    val signedIn = vm.signedIn.value

    if (signedIn && !alreadyLoggedIn.value) {
        alreadyLoggedIn.value = true
        navContoller.navigate(DestinationScreen.Profile.route) {
            popUpTo(0)
        }
    }
}

@Composable
fun CommonDivider() {
    Divider(
        color = Color.LightGray,
        thickness = 1.dp,
        modifier = Modifier
            .padding(top = 8.dp, bottom = 8.dp)
            .alpha(0.3f)
    )
}