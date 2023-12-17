package com.example.musclemasterapp.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.musclemasterapp.AppViewModel
import com.example.musclemasterapp.DestinationScreen
import com.example.musclemasterapp.R
import com.example.musclemasterapp.auth.ProfileContent
import com.example.musclemasterapp.navigation.BottomNavigationItem
import com.example.musclemasterapp.navigation.BottomNavigationMenu


@Composable
fun CalculatorsScreen(navController: NavController, vm: AppViewModel) {

    val isLoading = vm.inProgress.value
    if (isLoading) {
        CommonProgressSpinner()
    } else {
        val userData = vm.userData.value
        var gender by rememberSaveable { mutableStateOf(userData?.gender ?: "") }
        var weight by rememberSaveable { mutableStateOf(userData?.weight ?: "") }
        var height by rememberSaveable { mutableStateOf(userData?.height ?: "") }

        Calculatorcontent(
            navController = navController,
            gender = gender,
            weight = weight,
            height = height
        )
    }


}

@Composable
private fun Calculatorcontent(
    navController: NavController,
    gender: String,
    weight: String,
    height: String,
) {
    Surface {
        Column(modifier = Modifier.fillMaxSize()) {

            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 26.dp)
            ) {

                //
                Column {
                    BMICard(gender, weight, height)

                }

            }

            BottomNavigationMenu(
                selectedItem = BottomNavigationItem.CALCULATORS,
                navController = navController
            )
        }
    }
}

@Preview
@Composable
fun BMICard(gender: String ="male", weight: String = "80", height: String = "180") {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(500.dp)
            .border(
                width = 2.dp, color = Color(0xFF000000),
                shape = RoundedCornerShape(size = 4.dp)
            ),
        colors = CardDefaults.cardColors(Color(0xFFFFFFFF))
    ) {

        var showBmiInfo by remember { mutableStateOf(false) }

        Column(modifier = Modifier
            .padding(20.dp)
            .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally) {
            Row {
                Text(text = "BMI:",
                    style = TextStyle(
                        fontSize = 32.sp,
                        fontWeight = FontWeight(800),
                        color = Color(0xFF000000),
                        letterSpacing = 0.1.sp,
                    ),
                )

                Image(modifier = Modifier.clickable {
                    showBmiInfo = !showBmiInfo
                }.height(16.dp),
                    painter = painterResource(id = R.drawable.ic_quesion),
                    contentDescription = "Questin Mark"
                )
            }
            Divider(
                color = Color.LightGray,
                thickness = 1.dp,
                modifier = Modifier
                    .width(135.dp)
                    .background(color = Color(0xFFF5F5F5))
            )

            if (showBmiInfo) {
                Text(
                    text = "BMI is a measurement of a person's leanness or corpulence based on their " +
                            "height and weight, and is intended to quantify tissue mass. " +
                            "It is widely used as a general indicator of whether a person has a healthy " +
                            "body weight for their height.",
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontWeight = FontWeight(500),
                        color = Color(0xFF000000),
                        letterSpacing = 0.1.sp,
                    ),
                )
            }

            // Show BMI Value on Screen
            Text(
                text = calculateBMI(weight, height),
                style = TextStyle(
                    fontSize = 18.sp,
                    fontWeight = FontWeight(500),
                    color = Color(0xFF000000),
                    letterSpacing = 0.1.sp,
                ),
            )

            bmiIndicator(calculateBMI(weight, height))

        }



    }
    
}

private fun calculateBMI(weight: String, height: String): String {
    val weightInKg = weight.toDouble()
    val heightInMeters = height.toDouble() / 100 // cm to meter

    val bmi = weightInKg / (heightInMeters * heightInMeters)
    return String.format("%.2f", bmi)
}

private fun bmiIndicator(bmi: String): String {
    val bmiDouble = bmi.toDouble()

    return when {
        bmiDouble < 16 -> "Severe Thinness"
        bmiDouble < 17 -> "Moderate Thinness"
        bmiDouble < 18.5 -> "Mild Thinness"
        bmiDouble < 25 -> "Normal"
        bmiDouble < 30 -> "Overweight"
        bmiDouble < 35 -> "Obese Class I"
        bmiDouble < 40 -> "Obese Class II"
        else -> "Obese Class III"
    }
}
