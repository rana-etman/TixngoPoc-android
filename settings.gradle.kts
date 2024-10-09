pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        val storageUrl ="https://storage.googleapis.com"

        maven {
            url = uri("https://s3.eu-west-1.amazonaws.com/tixngo-public/sdk/android/v1.0.4")
        }
        maven {
            url =uri("$storageUrl/download.flutter.io")
        }
    }
}

rootProject.name = "TixngoDemo"
include(":app")
 