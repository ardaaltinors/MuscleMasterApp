package com.example.musclemasterapp.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.musclemasterapp.AppViewModel
import com.example.musclemasterapp.R
import com.example.musclemasterapp.data.Exercises
import com.example.musclemasterapp.data.getExercises
import java.time.format.TextStyle
import kotlin.reflect.typeOf

@Composable
fun ExerciseScreen(navController: NavController, vm: AppViewModel, muscleGroup: String) {

    val exerciseList = getExercises().filter { exercise ->
        exercise.exerciseTargetMuscle == muscleGroup
    }

    Surface {

        LazyColumn(modifier = Modifier.padding(8.dp)) {
            item {
                Text(text = "Best $muscleGroup exercises:",
                    style = MaterialTheme.typography.headlineLarge)
            }
            items(exerciseList) { exercise ->
                ExerciseRow(exercise.exerciseName,
                    exercise.exerciseImage,
                    exercise.exerciseDescription,
                    exercise.exerciseDifficulty)
            }
        }

    }
}


@Preview
@Composable
fun ExerciseRow(
    name: String = "Bench Press",
    image: String = "ex_bb_bench",
    description: String = "Egzersiz aciklamasi",
    difficulty: String = "Intermediate"
) {

    val context = LocalContext.current
    val imageResId = context.resources.getIdentifier(image, "drawable", context.packageName)

    Card(
        modifier = Modifier
            .padding(4.dp).padding(bottom = 12.dp)
            .fillMaxWidth()
            .background(Color(0xFFF4F7FA))
            .wrapContentHeight()
            .shadow(elevation = 6.dp),
        shape = RoundedCornerShape(corner = CornerSize(8.dp))
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = name, color = Color.Blue, fontSize = 22.sp)
            Text(text = difficulty)
        }

        CommonDivider()

        Column {
            if (imageResId != 0) {
                Image(
                    painter = painterResource(id = imageResId),
                    contentDescription = null,
                    modifier = Modifier
                        .height(180.dp)
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(corner = CornerSize(6.dp)))
                )
            }
            Text(text = description, modifier = Modifier.padding(6.dp))
        }

    }

}