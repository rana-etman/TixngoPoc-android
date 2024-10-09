plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "uk.org.lta.tixngodemo"
    compileSdk = 34

    defaultConfig {
        applicationId = "uk.org.lta.tixngodemo"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    debugImplementation ("io.tixngo.sdk:flutter_debug:v1.0.4")
    releaseImplementation ("io.tixngo.sdk:flutter_release:v1.0.4")
    debugImplementation ("io.tixngo.sdkUtils:sdkUtils-debug:v1.0.4")
    releaseImplementation ("io.tixngo.sdkUtils:sdkUtils-release:v1.0.4")
    implementation ("com.amazonaws:aws-android-sdk-core:2.49.0")
    implementation ("com.amazonaws:aws-android-sdk-cognitoidentityprovider:2.49.0")
    implementation ("com.google.firebase:firebase-messaging-ktx:23.0.6")
    implementation ("com.karumi:dexter:6.2.3")
}