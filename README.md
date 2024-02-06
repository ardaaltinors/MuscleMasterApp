
# Muscle Master Fitness App (Android)

MuscleMaster, the ultimate fitness helper app designed to assist you in your fitness journey. Whether you're a beginner or an experienced athlete, MuscleMaster provides a comprehensive set of features to help you achieve your fitness goals.

## Features

- **Personal Profile Creation**: Set up your profile by entering personal information such as height, weight, age, and gender to get personalized recommendations.
- **Muscle Group Selection**: Choose the muscle group you want to focus on and receive a curated list of the best exercises for that specific group.
- **BMI and Calorie Calculator**: Easily calculate your Body Mass Index (BMI) and daily caloric needs to keep track of your progress.
- **Custom Nutrition Program**: Get access to a personalized nutrition program designed to meet your fitness goals, powered by the Spoonacular API for the best meal plans.
- **MVVM Architecture**: Our app is built using the Model-View-ViewModel (MVVM) architecture to ensure a modular, maintainable, and testable codebase.
- **Firebase Integration**: User data is securely stored and managed with Google Firebase, utilizing Firestore for real-time database operations and Firebase Auth for authentication processes.
- **Advanced UI Navigation**: Navigate seamlessly through the app with the NavHost component, ensuring a smooth and intuitive user experience.
- **Image Mapping for Exercises**: Select target muscles through an interactive model with precise hit-boxes for an immersive experience.
- **Offline Data Management**: Exercise data is stored in local data classes, providing quick setup, independence from internet connectivity, and reliability.

## Getting Started

To get started with MuscleMaster, clone this repository to your local machine:

git clone https://github.com/ardaaltinors/MuscleMasterApp.git

### Prerequisites

Ensure you have the latest version of Android Studio installed to open and run the project. Firebase configuration is required to utilize the database and authentication features. Follow the Firebase documentation to set up your project accordingly.

### Installation

1. Open the project in Android Studio.
2. Configure your Firebase project and add the `google-services.json` file to your app module root directory.
3. Build the project to resolve all dependencies.
4. Run the app on your device or emulator.

## Usage

Upon launching MuscleMaster, you'll be redirected to create a profile. Follow the intuitive UI to navigate through the app's features, from selecting muscle groups to viewing your personalized nutrition program.

## Acknowledgments

- Google Firebase for user variables.
- Spoonacular API for the comprehensive meal plans.

