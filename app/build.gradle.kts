plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
}

android {
    namespace = "com.nokopi.buildvarianttest"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.nokopi.buildvarianttest"
        minSdk = 31
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
        create("demo") {
            isMinifyEnabled = false
        }
    }

    flavorDimensions += "hugahuga"
    productFlavors {
        create("sushi") {
            dimension = "hugahuga"
            applicationIdSuffix = ".sushi"
            versionNameSuffix = "-sushi"
            manifestPlaceholders["app_name"] = "sushi"
            manifestPlaceholders["app_icon"] = "@mipmap/ic_launcher"
            manifestPlaceholders["app_icon_round"] = "@mipmap/ic_launcher_round"
        }
        create("yakiniku") {
            dimension = "hugahuga"
            applicationIdSuffix = ".yakiniku"
            versionNameSuffix = "-yakiniku"
            manifestPlaceholders["app_name"] = "yakiniku"
            manifestPlaceholders["app_icon"] = "@mipmap/ic_launcher"
            manifestPlaceholders["app_icon_round"] = "@mipmap/ic_launcher_round"
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
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
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
}