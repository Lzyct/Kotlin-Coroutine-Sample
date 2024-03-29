plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("com.github.ben-manes.versions")
//    id("io.fabric") TODO add after register on firebase
}

android {
    dataBinding {
        isEnabled = true
    }
    compileSdkVersion(Android.compileSdk)
    defaultConfig {
        minSdkVersion(Android.minSdk)
        targetSdkVersion(Android.targetSdk)

        applicationId = Android.applicationId
        versionCode = Android.versionCode
        versionName = Android.versionName
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        buildConfigField("String", "BASE_URL", "\"https://apipt.pallakagroup.com\"")
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
        getByName("debug") {

        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }
}

//TODO disable for unused library
dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(Androidx.appcompat)
    implementation(Androidx.material)
    implementation(Androidx.recyclerview)
    implementation(Androidx.lifecycle)

    implementation(Ktx.navFragment)
    implementation(Ktx.navUI)
    implementation(Ktx.core)
    implementation(Ktx.runtime)

    implementation(Kotlin.stdlib)
    implementation(Kotlin.koin)

    implementation(Retrofit.core)
    implementation(Retrofit.converter)

    implementation(Room.rx)
    kapt(Room.compiler)

    implementation(Androidx.multidex)

    implementation(Log.okhttp)
    implementation(Log.logger)

    implementation(Extra.shimmer)
    implementation(Extra.coil)
}

//override limit error log to 1000
gradle.projectsEvaluated {
    tasks.withType(JavaCompile::class) {
        options.compilerArgs.addAll(arrayOf("-Xmaxerrs", "1000"))
    }
}