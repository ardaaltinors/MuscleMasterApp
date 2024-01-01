package com.example.musclemasterapp.data

data class Exercises(
    val exerciseName: String,
    val exerciseTargetMuscle: String,
    val exerciseDescription: String,
    val exerciseDifficulty: String,
    val exerciseImage: String
)

fun getExercises(): List<Exercises> {
    return listOf<Exercises>(

        // CHEST EGZ.
        Exercises(
            exerciseName = "Bench Press",
            exerciseTargetMuscle = "chest",
            exerciseDescription = "A classic exercise to target the chest muscles. It involves lying on a bench and pressing a weighted barbell upwards.",
            exerciseImage = "ex_bb_bench",
            exerciseDifficulty = "Intermediate"
        ),

        Exercises(
            exerciseName = "Push-up",
            exerciseTargetMuscle = "chest",
            exerciseDescription = "A bodyweight exercise where you lower your body to the ground and push back up, targeting the chest muscles.",
            exerciseImage = "ex_pushup",
            exerciseDifficulty = "Beginner"
        ),

        Exercises(
            exerciseName = "Chest Fly",
            exerciseTargetMuscle = "chest",
            exerciseDescription = "Performed with dumbbells or a cable machine, it involves extending the arms wide and bringing them together to target the chest.",
            exerciseImage = "ex_fly",
            exerciseDifficulty = "Intermediate"
        ),

        Exercises(
            exerciseName = "Incline Bench Press",
            exerciseTargetMuscle = "chest",
            exerciseDescription = "Similar to the bench press but performed on an inclined bench to target the upper chest muscles.",
            exerciseImage = "ex_inbp",
            exerciseDifficulty = "Intermediate"
        ),

        Exercises(
            exerciseName = "Decline Push-up",
            exerciseTargetMuscle = "chest",
            exerciseDescription = "A variation of the push-up where the feet are elevated, increasing the focus on the lower chest muscles.",
            exerciseImage = "ex_declinepu",
            exerciseDifficulty = "Advanced"
        ),

        // SHOULDER EGZ.
        Exercises(
            exerciseName = "Shoulder Press",
            exerciseTargetMuscle = "shoulder",
            exerciseDescription = "A strength exercise where you press weights upwards from your shoulders, targeting the deltoid muscles.",
            exerciseImage = "ex_shoulderpress",
            exerciseDifficulty = "Intermediate"
        ),
        Exercises(
            exerciseName = "Lateral Raise",
            exerciseTargetMuscle = "shoulder",
            exerciseDescription = "This exercise involves lifting dumbbells to the sides at shoulder level, targeting the lateral part of the shoulder muscles.",
            exerciseImage = "ex_lateralraise",
            exerciseDifficulty = "Beginner"
        ),
        Exercises(
            exerciseName = "Front Raise",
            exerciseTargetMuscle = "shoulder",
            exerciseDescription = "Performed by lifting dumbbells in front of your body to shoulder height, focusing on the anterior deltoids.",
            exerciseImage = "ex_frontraise",
            exerciseDifficulty = "Beginner"
        ),
        Exercises(
            exerciseName = "Reverse Fly",
            exerciseTargetMuscle = "shoulder",
            exerciseDescription = "A reverse fly is done by extending the arms out to the sides with dumbbells, targeting the rear deltoids and upper back.",
            exerciseImage = "ex_reversefly",
            exerciseDifficulty = "Intermediate"
        ),
        Exercises(
            exerciseName = "Arnold Press",
            exerciseTargetMuscle = "shoulder",
            exerciseDescription = "Named after Arnold Schwarzenegger, this variation of the shoulder press involves a rotational movement, targeting all parts of the deltoids.",
            exerciseImage = "ex_arnoldpress",
            exerciseDifficulty = "Advanced"
        ),


    // FOREARMS EGZ.
        Exercises(
            exerciseName = "Reverse Wrist Curl",
            exerciseTargetMuscle = "forearms",
            exerciseDescription = "Curling wrists upwards with the palms facing down.",
            exerciseImage = "ex_reverse_wrist_curl",
            exerciseDifficulty = "Beginner"
        ),
        Exercises(
            exerciseName = "Hammer Curl",
            exerciseTargetMuscle = "forearms",
            exerciseDescription = "Curling dumbbells with a neutral grip, targeting forearms along with biceps.",
            exerciseImage = "ex_hammer_curl",
            exerciseDifficulty = "Intermediate"
        ),
        Exercises(
            exerciseName = "Farmer's Walk",
            exerciseTargetMuscle = "forearms",
            exerciseDescription = "Carrying heavy weights in each hand and walking, strengthening the grip and forearms.",
            exerciseImage = "ex_farmers_walk",
            exerciseDifficulty = "Intermediate"
        ),
        Exercises(
            exerciseName = "Wrist Roller",
            exerciseTargetMuscle = "forearms",
            exerciseDescription = "Using a wrist roller to roll weights up and down, targeting forearm muscles.",
            exerciseImage = "ex_wrist_roller",
            exerciseDifficulty = "Intermediate"
        ),

    // ABS EGZ.
        Exercises(
            exerciseName = "Leg Raise",
            exerciseTargetMuscle = "abs",
            exerciseDescription = "Raising legs while lying down or hanging, targeting the lower abdominal muscles.",
            exerciseImage = "ex_leg_raise",
            exerciseDifficulty = "Intermediate"
        ),
        Exercises(
            exerciseName = "Plank",
            exerciseTargetMuscle = "abs",
            exerciseDescription = "Holding a plank position to engage the entire core.",
            exerciseImage = "ex_plank",
            exerciseDifficulty = "Beginner"
        ),
        Exercises(
            exerciseName = "Bicycle Crunches",
            exerciseTargetMuscle = "abs",
            exerciseDescription = "Simulating a cycling motion while performing crunches, targeting obliques and abs.",
            exerciseImage = "ex_bicycle_crunches",
            exerciseDifficulty = "Intermediate"
        ),
        Exercises(
            exerciseName = "Russian Twist",
            exerciseTargetMuscle = "abs",
            exerciseDescription = "Twisting the torso with weight to target obliques and abs.",
            exerciseImage = "ex_russian_twist",
            exerciseDifficulty = "Intermediate"
        ),

    // OBLIQUES EGZ.
        Exercises(
            exerciseName = "Wood Chop",
            exerciseTargetMuscle = "obliques",
            exerciseDescription = "Simulating a chopping motion with weights, targeting the oblique muscles.",
            exerciseImage = "ex_wood_chop",
            exerciseDifficulty = "Intermediate"
        ),
        Exercises(
            exerciseName = "Side Bend",
            exerciseTargetMuscle = "obliques",
            exerciseDescription = "Bending to the side with weights, focusing on the obliques.",
            exerciseImage = "ex_side_bend",
            exerciseDifficulty = "Beginner"
        ),
        Exercises(
            exerciseName = "Twisting Sit-Up",
            exerciseTargetMuscle = "obliques",
            exerciseDescription = "Performing sit-ups with a twist at the top to engage obliques.",
            exerciseImage = "ex_twisting_sit_up",
            exerciseDifficulty = "Intermediate"
        ),
        Exercises(
            exerciseName = "Hanging Side Leg Raise",
            exerciseTargetMuscle = "obliques",
            exerciseDescription = "Raising legs to the side while hanging, to target obliques.",
            exerciseImage = "ex_hanging_side_leg_raise",
            exerciseDifficulty = "Advanced"
        ),

    // TRAPS EGZ.
        Exercises(
            exerciseName = "Dumbbell Shrug",
            exerciseTargetMuscle = "traps",
            exerciseDescription = "Lifting dumbbells up and down in a shrugging motion, focusing on the trapezius muscles.",
            exerciseImage = "ex_dumbbell_shrug",
            exerciseDifficulty = "Beginner"
        ),
        Exercises(
            exerciseName = "Cable Shrug",
            exerciseTargetMuscle = "traps",
            exerciseDescription = "Performing shrugs using a cable machine for consistent tension on the traps.",
            exerciseImage = "ex_cable_shrug",
            exerciseDifficulty = "Intermediate"
        ),
        Exercises(
            exerciseName = "Barbell Row to Neck",
            exerciseTargetMuscle = "traps",
            exerciseDescription = "Pulling a barbell to the neck to target the upper back and traps.",
            exerciseImage = "ex_barbell_row_to_neck",
            exerciseDifficulty = "Advanced"
        ),
        Exercises(
            exerciseName = "Face Pull with External Rotation",
            exerciseTargetMuscle = "traps",
            exerciseDescription = "Performing a face pull with an additional external rotation to target traps and rear delts.",
            exerciseImage = "ex_face_pull_external_rotation",
            exerciseDifficulty = "Intermediate"
        ),

    // QUADS EGZ.
        Exercises(
            exerciseName = "Squat",
            exerciseTargetMuscle = "quads",
            exerciseDescription = "A fundamental exercise involving bending the knees and hips to lower the body and then standing back up.",
            exerciseImage = "ex_squat",
            exerciseDifficulty = "Intermediate"
        ),
        Exercises(
            exerciseName = "Lunges",
            exerciseTargetMuscle = "quads",
            exerciseDescription = "Stepping forward into a lunge position, targeting the quads.",
            exerciseImage = "ex_lunges",
            exerciseDifficulty = "Beginner"
        ),
        Exercises(
            exerciseName = "Leg Extension",
            exerciseTargetMuscle = "quads",
            exerciseDescription = "Using a leg extension machine to target the quadriceps.",
            exerciseImage = "ex_leg_extension",
            exerciseDifficulty = "Beginner"
        ),
        Exercises(
            exerciseName = "Hack Squat",
            exerciseTargetMuscle = "quads",
            exerciseDescription = "Performing a squat on a hack squat machine, focusing on the quadriceps.",
            exerciseImage = "ex_hack_squat",
            exerciseDifficulty = "Intermediate"
        ),

    // CALVES EGZ.
        Exercises(
            exerciseName = "Seated Calf Raise",
            exerciseTargetMuscle = "calves",
            exerciseDescription = "Raising the heels off the ground while seated, targeting the soleus muscle in the calves.",
            exerciseImage = "ex_seated_calf_raise",
            exerciseDifficulty = "Beginner"
        ),
        Exercises(
            exerciseName = "Leg Press Calf Raise",
            exerciseTargetMuscle = "calves",
            exerciseDescription = "Performing calf raises on a leg press machine, targeting both the soleus and gastrocnemius muscles.",
            exerciseImage = "ex_leg_press_calf_raise",
            exerciseDifficulty = "Intermediate"
        ),
        Exercises(
            exerciseName = "Donkey Calf Raise",
            exerciseTargetMuscle = "calves",
            exerciseDescription = "Performing calf raises with weight on the back, similar to a donkey's position.",
            exerciseImage = "ex_donkey_calf_raise",
            exerciseDifficulty = "Advanced"
        ),
        Exercises(
            exerciseName = "Single-Leg Calf Raise",
            exerciseTargetMuscle = "calves",
            exerciseDescription = "Raising the heel off the ground while standing on one leg, focusing on one calf at a time.",
            exerciseImage = "ex_single_leg_calf_raise",
            exerciseDifficulty = "Intermediate"
        ),

        // BICEPS EX.
        Exercises(
            exerciseName = "Dumbbell Curl",
            exerciseTargetMuscle = "biceps",
            exerciseDescription = "Lifting a dumbbell in each hand, curling the weight while keeping the elbows close to the torso.",
            exerciseImage = "ex_dumbell_curl",
            exerciseDifficulty = "Beginner"
        ),
        Exercises(
            exerciseName = "Barbell Curl",
            exerciseTargetMuscle = "biceps",
            exerciseDescription = "Curling a barbell upwards while maintaining a shoulder-width grip, emphasizing biceps muscle growth.",
            exerciseImage = "ex_barbell_curl",
            exerciseDifficulty = "Intermediate"
        ),
        Exercises(
            exerciseName = "Concentration Curl",
            exerciseTargetMuscle = "biceps",
            exerciseDescription = "Performing curls with a single dumbbell while seated, focusing on isolating the biceps muscle.",
            exerciseImage = "ex_concentration_curl",
            exerciseDifficulty = "Advanced"
        )

    )
}

