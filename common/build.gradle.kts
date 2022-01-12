import org.jetbrains.compose.compose

plugins {
    kotlin("multiplatform")
    kotlin("plugin.serialization") version "1.5.31"
    id("org.jetbrains.compose") version "1.0.0"
    id("com.android.library")
}

group = "com.example"
version = "1.0"

kotlin {
    android()
    jvm("desktop") {
        compilations.all {
            kotlinOptions.jvmTarget = "11"
        }
    }
    sourceSets {
        val kotlinxSerializationVersion = "1.3.1"
        val ktorVersion = "1.6.7"
        val commonMain by getting {
            dependencies {
                api(compose.runtime)
                api(compose.foundation)
                api(compose.material)

                api("org.jetbrains.kotlinx:kotlinx-serialization-core:$kotlinxSerializationVersion")
                api("org.jetbrains.kotlinx:kotlinx-serialization-json:$kotlinxSerializationVersion")
                api("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.0")

                api("io.ktor:ktor-client-core:$ktorVersion")
                api("io.ktor:ktor-client-serialization:$ktorVersion")
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val androidMain by getting {
            dependencies {
                api("androidx.appcompat:appcompat:1.2.0")
                api("androidx.core:core-ktx:1.3.1")
            }
        }
        val androidTest by getting {
            dependencies {
                implementation("junit:junit:4.13")
            }
        }
        val desktopMain by getting {
            dependencies {
                api(compose.preview)

                implementation("io.ktor:ktor-client-cio:$ktorVersion")
            }
        }
        val desktopTest by getting
    }
}

android {
    compileSdkVersion(31)
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdkVersion(24)
        targetSdkVersion(31)
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}