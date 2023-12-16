package com.example.musclemasterapp.main

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.asAndroidPath
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.example.musclemasterapp.AppViewModel
import com.example.musclemasterapp.R
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

@Composable
fun WorkoutsScreen(navController: NavController, vm: AppViewModel) {
    Surface {
        Column(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .background(Color(0xFFF4F7FA)),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center) {
                MuscleScreen()
            }

            BottomNavigationMenu(selectedItem = BottomNavigationItem.WORKOUTS, navController = navController)
        }
    }
}

@Composable
fun MuscleImageWithClickableAreas(onMuscleGroupClick: (String) -> Unit) {

    // Chest Imagemap
    val chestPath = Path().apply {
        val coords = listOf(
            220f, 348f, 241f, 336f, 257f, 322f, 277f, 298f, 294f, 278f, 320f, 261f, 342f, 255f,
            378f, 258f, 396f, 275f, 416f, 257f, 451f, 257f, 467f, 261f, 488f, 270f, 509f, 289f,
            526f, 311f, 547f, 332f, 570f, 351f, 544f, 359f, 527f, 380f, 509f, 390f, 479f, 398f,
            440f, 396f, 410f, 373f, 398f, 352f, 382f, 374f, 346f, 398f, 311f, 398f, 278f, 388f,
            251f, 358f
        )
        moveTo(coords[0], coords[1])
        for (i in 2 until coords.size step 2) {
            lineTo(coords[i], coords[i + 1])
        }
        close()
    }

    // Shoulders imagemap
    val shoulderPath = Path().apply {
        val coords = listOf(
            179.0f, 357.0f, 191.0f, 323.0f, 203.0f, 288.0f, 219.0f, 273.0f, 237.0f, 261.0f,
            273.0f, 249.0f, 303.0f, 254.0f, 323.0f, 258.0f, 289.0f, 279.0f, 272.0f, 304.0f,
            245.0f, 334.0f, 224.0f, 346.0f, 199.0f, 350.0f
        )
        moveTo(coords[0], coords[1])
        for (i in 2 until coords.size step 2) {
            lineTo(coords[i], coords[i + 1])
        }
        close()
    }
    val shoulderPath2 = Path().apply {
        val coords = listOf(612f, 359f, 568f, 348f, 543f, 327f, 521f, 304f, 501f, 279f, 482f,
            266f, 469f, 259f, 487f, 254f, 506f, 250f, 527f, 253f, 554f, 261f,
            571f, 271f, 582f, 283f, 594f, 300f)
        moveTo(coords[0], coords[1])
        for (i in 2 until coords.size step 2) {
            lineTo(coords[i], coords[i + 1])
        }
        close()
    }

    // Biceps imegamap
    val bicepsPath = Path().apply {
        val coords = listOf(179f, 364f, 162f, 383f, 152f, 404f, 143f, 424f, 138f, 444f, 138f, 475f,
            153f, 489f, 176f, 488f, 200f, 470f, 218f, 444f, 235f, 427f, 248f, 411f, 252f, 375f,
            244f, 358f, 225f, 351f, 201f, 354f)
        moveTo(coords[0], coords[1])
        for (i in 2 until coords.size step 2) {
            lineTo(coords[i], coords[i + 1])
        }
        close()
    }
    val bicepsPath2 = Path().apply {
        val coords = listOf(571f, 352f, 604f, 355f, 616f, 365f, 631f, 387f, 642f, 407f, 652f, 435f,
            655f, 466f, 643f, 487f, 617f, 490f, 598f, 478f, 582f, 456f, 557f, 428f, 543f, 399f,
            541f, 378f, 543f, 364f, 549f, 353f)
        moveTo(coords[0], coords[1])
        for (i in 2 until coords.size step 2) {
            lineTo(coords[i], coords[i + 1])
        }
        close()
    }

    // Forearms imagemap
    val forearmsPath = Path().apply {
        val coords = listOf(137f, 440f, 114f, 463f, 95f, 488f, 78f, 522f, 63f, 555f, 42f, 608f, 40f,
            621f, 50f, 630f, 71f, 631f, 94f, 601f, 134f, 568f, 162f, 527f, 178f, 499f, 187f,
            486f, 156f, 492f, 138f, 476f)
        moveTo(coords[0], coords[1])
        for (i in 2 until coords.size step 2) {
            lineTo(coords[i], coords[i + 1])
        }
        close()
    }
    val forearmsPath2 = Path().apply {
        val coords = listOf(655f, 438f, 680f, 466f, 702f, 495f, 754f, 613f, 745f, 629f, 722f,
            632f, 710f, 615f, 663f, 576f, 622f, 507f, 603f, 481f, 625f, 491f, 645f, 486f, 654f, 467f)
        moveTo(coords[0], coords[1])
        for (i in 2 until coords.size step 2) {
            lineTo(coords[i], coords[i + 1])
        }
        close()
    }

    // Abs imagemap
    val abs = Path().apply {
        val coords = listOf(330f, 408f, 350f, 394f, 385f, 388f, 395f, 399f, 408f, 386f, 436f,
            394f, 465f, 409f, 460f, 437f, 459f, 469f, 446f, 621f, 408f, 682f, 385f,
            686f, 363f, 657f, 337f, 586f)
        moveTo(coords[0], coords[1])
        for (i in 2 until coords.size step 2) {
            lineTo(coords[i], coords[i + 1])
        }
        close()
    }

    // Obliques imagemap
    val obliques = Path().apply {
        val coords = listOf(248f, 363f, 286f, 400f, 331f, 440f, 328f, 482f, 324f, 525f, 328f, 555f,
            311f, 603f, 277f, 606f, 284f, 503f, 262f, 454f, 246f, 418f)
        moveTo(coords[0], coords[1])
        for (i in 2 until coords.size step 2) {
            lineTo(coords[i], coords[i + 1])
        }
        close()
    }
    val obliques2 = Path().apply {
        val coords = listOf(541f, 364f, 498f, 407f, 459f, 439f, 464f, 482f, 468f, 536f, 468f, 575f,
            485f, 605f, 516f, 608f, 506f, 514f, 532f, 454f, 545f, 415f)
        moveTo(coords[0], coords[1])
        for (i in 2 until coords.size step 2) {
            lineTo(coords[i], coords[i + 1])
        }
        close()
    }

    // Traps imagemap
    val traps = Path().apply {
        val coords = listOf(279f, 248f, 347f, 209f, 348f, 244f, 329f, 258f)
        moveTo(coords[0], coords[1])
        for (i in 2 until coords.size step 2) {
            lineTo(coords[i], coords[i + 1])
        }
        close()
    }
    val traps2 = Path().apply {
        val coords = listOf(515f, 250f, 445f, 210f, 445f, 249f, 466f, 257f)
        moveTo(coords[0], coords[1])
        for (i in 2 until coords.size step 2) {
            lineTo(coords[i], coords[i + 1])
        }
        close()
    }
    // Quads imagemap
    val quads = Path().apply {
        val coords = listOf(277f, 612f, 241f, 808f, 252f, 947f, 271f, 974f, 291f, 971f, 304f, 1006f,
            331f, 1000f, 348f, 968f, 361f, 887f, 328f, 820f, 301f, 645f)
        moveTo(coords[0], coords[1])
        for (i in 2 until coords.size step 2) {
            lineTo(coords[i], coords[i + 1])
        }
        close()
    }
    val quads2 = Path().apply {
        val coords = listOf(516f, 613f, 546f, 775f, 548f, 890f, 531f, 967f, 502f, 969f, 488f, 1002f,
            464f, 1002f, 437f, 952f, 432f, 879f, 467f, 804f, 491f, 632f)
        moveTo(coords[0], coords[1])
        for (i in 2 until coords.size step 2) {
            lineTo(coords[i], coords[i + 1])
        }
        close()
    }
    // Calves imagemap
    val calves = Path().apply {
        val coords = listOf(253f, 1028f, 234f, 1085f, 236f, 1154f, 318f, 1158f, 329f, 1121f, 320f, 1047f)
        moveTo(coords[0], coords[1])
        for (i in 2 until coords.size step 2) {
            lineTo(coords[i], coords[i + 1])
        }
        close()
    }
    val calves2 = Path().apply {
        val coords = listOf(473f, 1044f, 539f, 1027f, 559f, 1110f, 556f, 1151f, 476f, 1159f, 461f, 1127f)
        moveTo(coords[0], coords[1])
        for (i in 2 until coords.size step 2) {
            lineTo(coords[i], coords[i + 1])
        }
        close()
    }

    Box(contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .pointerInput(Unit) {
                detectTapGestures { offset ->
                    if (chestPath.contains(offset.x, offset.y)) {
                        onMuscleGroupClick("chest")
                    }
                    if (shoulderPath.contains(offset.x, offset.y)) {
                        onMuscleGroupClick("shoulder")
                    }
                    if (shoulderPath2.contains(offset.x, offset.y)) {
                        onMuscleGroupClick("shoulder")
                    }
                    if (bicepsPath.contains(offset.x, offset.y)) {
                        onMuscleGroupClick("biceps")
                    }
                    if (bicepsPath2.contains(offset.x, offset.y)) {
                        onMuscleGroupClick("biceps")
                    }
                    if (forearmsPath.contains(offset.x, offset.y)) {
                        onMuscleGroupClick("forearms")
                    }
                    if (forearmsPath2.contains(offset.x, offset.y)) {
                        onMuscleGroupClick("forearms")
                    }
                    if (abs.contains(offset.x, offset.y)) {
                        onMuscleGroupClick("abs")
                    }
                    if (obliques.contains(offset.x, offset.y)) {
                        onMuscleGroupClick("obliques")
                    }
                    if (obliques2.contains(offset.x, offset.y)) {
                        onMuscleGroupClick("obliques")
                    }
                    if (traps.contains(offset.x, offset.y)) {
                        onMuscleGroupClick("traps")
                    }
                    if (traps2.contains(offset.x, offset.y)) {
                        onMuscleGroupClick("traps")
                    }
                    if (quads.contains(offset.x, offset.y)) {
                        onMuscleGroupClick("quads")
                    }
                    if (quads2.contains(offset.x, offset.y)) {
                        onMuscleGroupClick("quads")
                    }
                    if (calves.contains(offset.x, offset.y)) {
                        onMuscleGroupClick("calves")
                    }
                    if (calves2.contains(offset.x, offset.y)) {
                        onMuscleGroupClick("calves")
                    }
                }
            }
    ) {
        Image(
            painter = painterResource(id =R.drawable.model_front_male),
            contentDescription = "Muscle Groups"
        )

        // Debug icin canvas
        /*Canvas(modifier = Modifier.matchParentSize()) {
            drawPath(
                path = shoulderPath2,
                color = Color.Red.copy(alpha = 0.3f)
            )
        }*/
    }
}

// Contains fonksiyonu Path'in içerisinde kullanmak için
fun Path.contains(x: Float, y: Float): Boolean {
    val androidPath = this.asAndroidPath()
    return android.graphics.Region().apply {
        setPath(androidPath, android.graphics.Region(0, 0, 10000, 10000))
    }.contains(x.toInt(), y.toInt())
}

@Composable
fun MuscleScreen() {
    // Kas grubuna tıklandığında ne yapılacağını tanımlayın
    val onMuscleGroupClick: (String) -> Unit = { muscleGroup ->
        // TODO: Tıklanan kas grubuna göre işlem yap
        println("$muscleGroup tıklandı")
    }

    // Kas resmi ve tıklanabilir alanları içeren composable fonksiyonu çağırın
    MuscleImageWithClickableAreas(onMuscleGroupClick = onMuscleGroupClick)
}