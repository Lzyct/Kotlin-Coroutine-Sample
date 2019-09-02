//define Version library
object Version {
    const val kotlin = "1.3.50"
    const val androidPlugin = "3.4.2"
    const val playService = "4.3.1"
    const val fabric = "1.31.0"
    const val updateLib = "0.21.0"
    const val navigation = "2.1.0-alpha03"

    const val androidx = "1.1.0-rc01"
    const val lifecycle = "2.2.0-alpha03"
    const val multidex = "2.0.1"


    const val retrofit = "2.6.1"
    const val koin = "2.0.1"
    const val room = "2.2.0-beta01"
    const val work = "2.1.0"
    const val ktx = "1.2.0-alpha01"



    const val okhttpLog = "4.1.0"
    const val logger = "2.2.0"
    const val debugDb = "1.0.6"
}

//Build gradle on root
object Build {
    const val android = "com.android.tools.build:gradle:${Version.androidPlugin}"
    const val kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Version.kotlin}"
    const val playService = "com.google.gms:google-services:${Version.playService}"
    const val updateLib = "com.github.ben-manes:gradle-versions-plugin:${Version.updateLib}"
    const val navigation = "androidx.navigation:navigation-safe-args-gradle-plugin:${Version.navigation}"
}

//Build gradle app
//TODO : change application id here
object Android {
    const val applicationId = "com.tuxdev.coroutines"
    const val compileSdk = 28
    const val minSdk = 21
    const val targetSdk = 28
    const val versionCode = 1
    const val versionName = "1.0"
}

object Androidx {
    const val appcompat = "androidx.appcompat:appcompat:${Version.androidx}"
    const val material = "com.google.android.material:material:1.1.0-alpha09"
    const val recyclerview = "androidx.recyclerview:recyclerview:1.1.0-beta03"
    const val lifecycle = "androidx.lifecycle:lifecycle-extensions:${Version.lifecycle}"
    const val multidex = "androidx.multidex:multidex:${Version.multidex}"
}

object Ktx {
    const val worker = "androidx.work:work-rxjava2:${Version.work}"
    const val core = "androidx.core:core-ktx:${Version.ktx}"
    const val runtime = "androidx.navigation:navigation-runtime-ktx:${Version.navigation}"
    const val fragment = "androidx.fragment:fragment-ktx:${Version.ktx}"
    const val navFragment = "androidx.navigation:navigation-fragment-ktx:${Version.navigation}"
    const val navUI = "androidx.navigation:navigation-ui-ktx:${Version.navigation}"
}

object Kotlin {
    const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Version.kotlin}"
    const val koin = "org.koin:koin-androidx-viewmodel:${Version.koin}"
    const val coroutineCore="org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.0"
    const val coroutineAndroid ="org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.0"
}


object Retrofit {
    const val core = "com.squareup.retrofit2:retrofit:${Version.retrofit}"
    const val converter = "com.squareup.retrofit2:converter-moshi:${Version.retrofit}"
}

object Room {
    const val rx = "androidx.room:room-rxjava2:${Version.room}"
    const val compiler = "androidx.room:room-compiler:${Version.room}"
    const val debug = "com.amitshekhar.android:debug-db:${Version.debugDb}"
}


object Log {
    const val okhttp = "com.squareup.okhttp3:logging-interceptor:${Version.okhttpLog}"
    const val logger = "com.orhanobut:logger:${Version.logger}"
}

object Extra {
    const val shimmer = "com.facebook.shimmer:shimmer:0.5.0"
    const val coil = "io.coil-kt:coil:0.6.1"
}