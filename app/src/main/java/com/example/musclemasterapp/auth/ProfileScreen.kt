package com.example.musclemasterapp.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.musclemasterapp.AppViewModel
import com.example.musclemasterapp.DestinationScreen
import com.example.musclemasterapp.R
import com.example.musclemasterapp.navigation.BottomNavigationItem
import com.example.musclemasterapp.navigation.BottomNavigationMenu
import com.example.musclemasterapp.main.CommonDivider
import com.example.musclemasterapp.main.CommonProgressSpinner
import com.example.musclemasterapp.main.navigateTo

@Composable
fun ProfileScreen(navController: NavController, vm: AppViewModel) {
    val isLoading = vm.inProgress.value
    if (isLoading) {
        CommonProgressSpinner()
    } else {
        val userData = vm.userData.value
        var username by rememberSaveable { mutableStateOf(userData?.username ?: "") }
        var gender by rememberSaveable { mutableStateOf(userData?.gender ?: "") }
        var weight by rememberSaveable { mutableStateOf(userData?.weight ?: "") }
        var height by rememberSaveable { mutableStateOf(userData?.height ?: "") }
        var age by rememberSaveable { mutableStateOf(userData?.age ?: "") }

        ProfileContent(
            vm = vm,
            navController = navController,
            username = username,
            gender = gender,
            weight = weight,
            height = height,
            age = age,
            onUsernameChange = { username = it },
            onGenderChange = { gender = it },
            onWeightChange = { weight = it },
            onHeightChange = { height = it },
            onAgeChange = { age = it },
            onSave = { vm.updateProfileData(username, gender, weight, height, age) },
            onLogout = {
                vm.onLogout()
                navigateTo(navController, DestinationScreen.Login)
            }
        )

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileContent(
    vm: AppViewModel,
    navController: NavController,
    username: String,
    gender: String = "female",
    weight: String,
    height: String,
    age: String,
    onUsernameChange: (String) -> Unit,
    onGenderChange: (String) -> Unit,
    onWeightChange: (String) -> Unit,
    onHeightChange: (String) -> Unit,
    onAgeChange: (String) -> Unit,
    onSave: () -> Unit,
    onLogout: () -> Unit
) {

    val scrollState = rememberScrollState()

    Surface {
        Column(modifier = Modifier
            .verticalScroll(scrollState)
        ) {
            Column(modifier = Modifier
                .weight(1f)
                .padding(8.dp)) {

                //Ust Navigasyon
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ){
                    Text(text = "Logout", modifier = Modifier.clickable { onLogout.invoke() }, color = Color.Red)
                    Text(text = "Save", modifier = Modifier.clickable { onSave.invoke() })
                }

                CommonDivider()

                Column(modifier = Modifier.padding(horizontal = 30.dp, vertical = 10.dp),
                    horizontalAlignment = Alignment.CenterHorizontally) {
                    // Kullanici bilgileri
                    Image(painter = painterResource(id = if (gender == "male") R.drawable.mascot_male
                    else R.drawable.masoc_female),
                        contentDescription = "Mascot",
                        modifier = Modifier
                            .height(210.dp)
                            .padding(6.dp))

                    OutlinedTextField(
                        value = username,
                        onValueChange = onUsernameChange,
                        modifier = Modifier
                            .padding(8.dp)
                            .fillMaxWidth(),
                        shape = RoundedCornerShape(8.dp),
                        label = { Text(text = "Username") }
                    )
                    OutlinedTextField(
                        value = height,
                        onValueChange = onHeightChange,
                        modifier = Modifier
                            .padding(8.dp)
                            .fillMaxWidth(),
                        shape = RoundedCornerShape(8.dp),
                        label = { Text(text = "Height") }
                    )
                    OutlinedTextField(
                        value = weight,
                        onValueChange = onWeightChange,
                        modifier = Modifier
                            .padding(8.dp)
                            .fillMaxWidth(),
                        shape = RoundedCornerShape(8.dp),
                        label = { Text(text = "Weight") }
                    )

                    GenderSelector(
                        selectedGender = gender,
                        onGenderChange = onGenderChange
                    )

                    OutlinedTextField(
                        value = age,
                        onValueChange = onAgeChange,
                        modifier = Modifier
                            .padding(8.dp)
                            .fillMaxWidth(),
                        shape = RoundedCornerShape(8.dp),
                        label = { Text(text = "Age") }
                    )
                }



            }
            BottomNavigationMenu(selectedItem = BottomNavigationItem.PROFILE, navController = navController)
        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GenderSelector(
    selectedGender: String,
    onGenderChange: (String) -> Unit
) {
    var showDialog by remember { mutableStateOf(false) }
    val genderOptions = listOf("male", "female")

    OutlinedTextField(
        value = selectedGender,
        onValueChange = { },
        readOnly = true,
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { showDialog = true },
        label = { Text("Gender") },
        trailingIcon = {
            Icon(
                imageVector = Icons.Default.ArrowDropDown,
                contentDescription = "Dropdown",
                modifier = Modifier.clickable { showDialog = true }
            )
        },
        colors = TextFieldDefaults.outlinedTextFieldColors()
    )

    if (showDialog) {
        AlertDialog(
            onDismissRequest = { showDialog = false },
            title = { Text("Select Gender") },
            text = {
                Column {
                    genderOptions.forEach { gender ->
                        TextButton(
                            onClick = {
                                onGenderChange(gender)
                                showDialog = false
                            }
                        ) {
                            Text(gender)
                        }
                    }
                }
            },
            confirmButton = {
                TextButton(
                    onClick = { showDialog = false }
                ) {
                    Text("Cancel")
                }
            }
        )
    }
}


