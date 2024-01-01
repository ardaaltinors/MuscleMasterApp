package com.example.musclemasterapp.api

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.musclemasterapp.R
import com.example.musclemasterapp.api.model.Meal
import com.example.musclemasterapp.api.model.MealPlan
import com.example.musclemasterapp.api.model.Nutrients
import com.example.musclemasterapp.data.DataOrException

@Composable
fun MealPlanScreen(navController: NavController, mealViewModel: MealViewModel = hiltViewModel(), targetCalories: String) {

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {


        Column(
            modifier = Modifier
                .padding(6.dp)
                .background(Color.White)
                .fillMaxSize()
        ) {

            Text(text = "Target cal: $targetCalories")

            ShowMealPlan(mealViewModel = mealViewModel , targetCalories)
        }

    }
}

@Composable
fun ShowMealPlan(mealViewModel: MealViewModel, targetCalories: String) {

    val mealPlanData = produceState<DataOrException<MealPlan, Boolean, Exception>>(
        initialValue = DataOrException(loading = true)
    ) {
        value = mealViewModel.getMealPlanData(targetCalories = targetCalories)
    }.value

    if (mealPlanData.loading == true) {
        CircularProgressIndicator()
    } else if (mealPlanData.data != null) {
        //Text(text = mealPlanData.data!!.week.toString())

        // burada cardlar gozuksun

        DisplayMealPlan(mealPlan = mealPlanData.data!!)
    }

}

@Composable
fun DisplayMealPlan(mealPlan: MealPlan) {
    mealPlan.week?.let {
        LazyColumn {
            item { MealCard(day = "Monday", meals = it.monday.meals, nutrients = it.monday.nutrients) }
            item { MealCard(day = "Tuesday", meals = it.tuesday.meals, nutrients = it.tuesday.nutrients) }
            item { MealCard(day = "Wednesday", meals = it.wednesday.meals, nutrients = it.wednesday.nutrients) }
            item { MealCard(day = "Thursday", meals = it.thursday.meals, nutrients = it.thursday.nutrients) }
            item { MealCard(day = "Friday", meals = it.friday.meals, nutrients = it.friday.nutrients) }
            item { MealCard(day = "Saturday", meals = it.saturday.meals, nutrients = it.saturday.nutrients) }
            item { MealCard(day = "Sunday", meals = it.sunday.meals, nutrients = it.sunday.nutrients) }
        }
    }
}


@Composable
fun MealCard(day: String, meals: List<Meal>, nutrients: Nutrients) {

    Card(
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth()
            .background(Color(0xFFF4F7FA))
            .wrapContentHeight()
            .shadow(elevation = 1.dp),
        shape = RoundedCornerShape(corner = CornerSize(20.dp))
    ) {
        Column {
            Row(
                modifier = Modifier
                    .padding(12.dp)
                    .background(Color.LightGray)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Image(painter = painterResource(id = R.drawable.ic_food), contentDescription = null)
                Text(
                    text = day,
                    style = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.ExtraBold),
                    modifier = Modifier.padding(start = 10.dp)
                )
            }

            Text(text = "Calories: ${nutrients.calories} | Protein: ${nutrients.protein} | " +
                    "Fat: ${nutrients.fat} | Carb: ${nutrients.carbohydrates}",
                style = TextStyle(fontSize = 14.sp))

            Divider()

            meals.forEach { meal ->
                Column(modifier = Modifier.padding(12.dp)) {

                    Text(text = meal.title,
                        style = TextStyle(fontSize = 21.sp))
                }
            }
        }
    }
}