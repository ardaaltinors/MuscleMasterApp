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
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
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
        var age by rememberSaveable { mutableStateOf(userData?.age ?: "") }

        Calculatorcontent(
            navController = navController,
            gender = gender,
            weight = weight,
            height = height,
            age = age
        )
    }


}

@Composable
private fun Calculatorcontent(
    navController: NavController,
    gender: String,
    weight: String,
    height: String,
    age: String,
) {
    Surface {
        Column(modifier = Modifier.fillMaxSize()) {

            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 18.dp)
            ) {

                //
                Column {

                    Button(onClick = { navigateTo(navContoller = navController, DestinationScreen.MealPlan) }) {
                        Text(text = "Meal plan")
                    }

                    BMICard(gender, weight, height)

                    CalorieCard(gender, weight, height, age)

                }

            }


            // Bottom Nav
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
            .padding(10.dp)
            .wrapContentHeight()
            .border(
                width = 1.dp, color = Color(0xFF000000),
                shape = RoundedCornerShape(size = 4.dp)
            ),
        colors = CardDefaults.cardColors(Color(0xFFFFFFFF))
    ) {

        var showBmiInfo by remember { mutableStateOf(false) }

        Column(modifier = Modifier
            .padding(20.dp)
            .fillMaxWidth()
            .wrapContentHeight(),
            horizontalAlignment = Alignment.CenterHorizontally) {
            Row {
                Text(text = "BMI:",
                    style = TextStyle(
                        fontSize = 30.sp,
                        fontWeight = FontWeight(800),
                        color = Color(0xFF000000),
                        letterSpacing = 0.1.sp,
                    ),
                )

                Image(modifier = Modifier
                    .clickable {
                        showBmiInfo = !showBmiInfo
                    }
                    .height(16.dp),
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
                AlertDialog(
                    onDismissRequest = { showBmiInfo = false },
                    title = { Text("What is BMI?") },
                    text = {
                        Column {
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
                    },
                    confirmButton = {
                        TextButton(
                            onClick = { showBmiInfo = false }
                        ) {
                            Text("Close")
                        }
                    }
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

            Text(
                text = bmiIndicator(calculateBMI(weight, height)),
                style = TextStyle(
                    fontSize = 18.sp,
                    fontWeight = FontWeight(500),
                    color = Color(0xFF000000),
                    letterSpacing = 0.1.sp,
                ),
            )
        }
    }
    
}

@Composable
fun CalorieCard(gender: String ="male", weight: String = "80", height: String = "180", age: String = "21") {

    var selectedActivityLevel by remember { mutableStateOf(0) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .border(
                width = 1.dp, color = Color(0xFF000000),
                shape = RoundedCornerShape(size = 4.dp)
            ),
        colors = CardDefaults.cardColors(Color(0xFFFFFFFF))
    ) {

        var showCalorieInfo by remember { mutableStateOf(false) }

        Column(modifier = Modifier
            .padding(20.dp)
            .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally) {
            Row {
                Text(text = "Daily Calorie Need:",
                    style = TextStyle(
                        fontSize = 30.sp,
                        fontWeight = FontWeight(800),
                        color = Color(0xFF000000),
                        letterSpacing = 0.1.sp,
                    ),
                )

                Image(modifier = Modifier
                    .clickable {
                        showCalorieInfo = !showCalorieInfo
                    }
                    .height(16.dp),
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

            if (showCalorieInfo) {
                AlertDialog(
                    onDismissRequest = { showCalorieInfo = false },
                    title = { Text("About caloric requierement:") },
                    text = {
                        Column {
                            Text(
                                text = "Our daily caloric requirement is the amount of calories we need to " +
                                        "consume in a day to maintain our weight. If our goal is to lose weight " +
                                        "and burn fat, we should consume less than our daily caloric " +
                                        "requirement. Conversely, if our aim is to gain weight and build muscle, " +
                                        "we should consume more than our daily caloric requirement.",
                                style = TextStyle(
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight(500),
                                    color = Color(0xFF000000),
                                    letterSpacing = 0.1.sp,
                                ),
                            )
                        }
                    },
                    confirmButton = {
                        TextButton(
                            onClick = { showCalorieInfo = false }
                        ) {
                            Text("Close")
                        }
                    }
                )
            }

            // Show Calorie Value on Screen
            ActivityLevelSelector(
                selectedActivityLevel = selectedActivityLevel,
                onActivityLevelChange = { newLevel ->
                    selectedActivityLevel = newLevel
                }
            )

            var caloricNeed = calculateCalorie(
                weight = weight,
                height = height,
                age = age,
                gender = gender,
                activityLevel = selectedActivityLevel
            ).toInt()


            Text(
                text = "${caloricNeed.toString()} kal",
                style = TextStyle(
                    fontSize = 22.sp,
                    fontWeight = FontWeight(500),
                    color = Color(0xFF000000),
                    letterSpacing = 0.1.sp,
                ),
            )

            Text(
                text = dietSuggestion(bmiValue = calculateBMI(weight, height)),
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight(500),
                    color = Color(0xFF000000),
                    letterSpacing = 0.1.sp,
                ),
            )

            //
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

fun calculateCalorie(weight: String, height: String, age: String, gender: String, activityLevel: Int): Double {
    val weightKg = weight.toDouble()
    val heightCm = height.toDouble()
    val ageYears = age.toDouble()

    val bmr = if (gender.equals("male", ignoreCase = true)) {
        10 * weightKg + 6.25 * heightCm - 5 * ageYears + 5
    } else {
        10 * weightKg + 6.25 * heightCm - 5 * ageYears - 161
    }

    return when (activityLevel) {
        1 -> bmr * 1.2   // Sedentary
        2 -> bmr * 1.375 // Light
        3 -> bmr * 1.55  // Moderate
        4 -> bmr * 1.725 // Active
        5 -> bmr * 1.9   // Very Active
        6 -> bmr * 2.0   // Extra Active
        else -> bmr
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ActivityLevelSelector(
    selectedActivityLevel: Int,
    onActivityLevelChange: (Int) -> Unit
) {
    var showDialog by remember { mutableStateOf(false) }
    val activityLevelOptions = listOf(
        "Basal Metabolic Rate (BMR)",
        "Sedentary: little or no exercise",
        "Light: exercise 1–3 times/week",
        "Moderate: exercise 4–5 times/week",
        "Active: daily exercise or intense exercise 3–4 times/week",
        "Very Active: intense exercise 6–7 times/week",
        "Extra Active: very intense exercise daily, or physical job"
    )
    val activityLevelString = activityLevelOptions.getOrElse(selectedActivityLevel) { "Select Activity Level" }

    OutlinedTextField(
        value = activityLevelString,
        onValueChange = { },
        readOnly = true,
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { showDialog = true },
        label = { Text("Activity Level") },
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
            title = { Text("Select Activity Level") },
            text = {
                Column {
                    activityLevelOptions.forEachIndexed { index, activityLevel ->
                        TextButton(
                            onClick = {
                                onActivityLevelChange(index)
                                showDialog = false
                            }
                        ) {
                            Text(activityLevel)
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

private fun dietSuggestion(bmiValue: String): String {
    val bmiCategory = bmiIndicator(bmiValue)

    return when (bmiCategory) {
        "Severe Thinness" -> "It's important to seek medical advice. A diet rich in calories and nutrients is usually recommended."
        "Moderate Thinness" -> "Consider increasing your intake of calories and nutrients. Focus on balanced meals with proteins, fats, and carbohydrates."
        "Mild Thinness" -> "Include nutrient-rich foods that are high in calories. Whole grains, lean meats, and dairy products are good choices."
        "Normal" -> "Maintain your current balanced diet. Focus on a mix of fruits, vegetables, whole grains, proteins, and healthy fats."
        "Overweight" -> "Consider a balanced diet with a slight calorie deficit. Focus on whole foods and limit high-calorie and high-sugar items."
        "Obese Class I" -> "A diet plan with a moderate calorie deficit is recommended. Emphasize on fruits, vegetables, and lean proteins. Avoid processed foods."
        "Obese Class II" -> "A carefully planned diet, possibly under the guidance of a dietitian, is important. Aim for a calorie-controlled diet rich in nutrients."
        "Obese Class III" -> "Medical supervision for diet planning is highly recommended. Focus on a nutrient-dense, calorie-controlled diet."
        else -> "Error: Unknown BMI category"
    }
}

