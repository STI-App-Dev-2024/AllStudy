pluginManagement {
    repositories {
        google() // Ensure Google's Maven repository is included
        mavenCentral() // Use Maven Central for additional dependencies
        gradlePluginPortal() // For Gradle Plugin Portal to resolve Gradle plugins
    }
    resolutionStrategy {
        // Optional: you can add a resolution strategy if needed
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS) // Enforce that only central repositories are used
    repositories {
        google() // Google's repository for Android-related dependencies
        mavenCentral() // Central repository for general dependencies
    }
}

rootProject.name = "All-Study" // Set the root project name

// Include the app module
include(":app")

// Optional: Add other modules if necessary
// include(":module1")
// include(":module2")
