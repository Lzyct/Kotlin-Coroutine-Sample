import com.github.benmanes.gradle.versions.updates.DependencyUpdatesTask


buildscript {
    repositories {
        google()
        jcenter()
        mavenCentral()
        maven("https://maven.fabric.io/public")
        maven("https://plugins.gradle.org/m2/")
    }
    dependencies {
        classpath(Build.android)
        classpath(Build.kotlin)
        classpath(Build.playService)
        classpath("com.github.ben-manes:gradle-versions-plugin:0.23.0")
//        classpath(Build.fabric) TODO add after register on firebase
        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module Build.gradle files
    }
}

allprojects {
    repositories {
        google()
        jcenter()
        mavenCentral()
        maven("https://maven.google.com")
        maven("https://jitpack.io")
    }
}

task("clean") {
    delete(rootProject.buildDir)
}

tasks.register("dependencyUpdates", DependencyUpdatesTask::class) {
    resolutionStrategy {
        componentSelection {
            all {
                val rejected = listOf("beta", "cr", "m", "preview") // > exclude this version "alpha","rc"
                        .map { qualifier -> Regex("(?i).*[.-]$qualifier[.\\d-]*") }
                        .any { it.matches(candidate.version) }
                if (rejected) {
                    reject("Release candidate")
                }
            }
        }
    }
    // optional parameters
    checkForGradleUpdate = true
    outputFormatter = "json"
    outputDir = "build/dependencyUpdates"
    reportfileName = "report"
}
