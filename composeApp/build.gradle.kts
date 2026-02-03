import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import java.util.Properties
import java.io.FileInputStream

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsCompose)
    alias(libs.plugins.compose.compiler)
}

kotlin {
    androidTarget {
        @OptIn(ExperimentalKotlinGradlePluginApi::class)
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_11)
        }
    }
    
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "ComposeApp"
            isStatic = true
        }
    }
    
    jvm("desktop")
    
    sourceSets {
        val desktopMain by getting
        
        androidMain.dependencies {
            implementation(libs.androidx.activity.compose)
            implementation(libs.androidx.appcompat)
            implementation(libs.androidx.core.ktx)
            implementation(libs.koin.android)
        }
        
        commonMain.dependencies {
            implementation(projects.shared) // Depend on shared module
            
            implementation(libs.compose.ui)
            implementation(libs.compose.foundation)
            implementation(libs.compose.material3)
            implementation(libs.compose.material.icons)
            implementation(libs.compose.ui.tooling.preview)
            
            implementation(libs.koin.core)
            implementation(libs.koin.compose)
            implementation(libs.koin.compose.viewmodel)
            implementation(libs.navigation.compose)
        }
        
        desktopMain.dependencies {
            implementation(libs.compose.ui.tooling.preview)
            // Explicit ARM64 Skiko runtime for Windows ARM64 native support
            implementation("org.jetbrains.skiko:skiko-awt-runtime-windows-arm64:0.9.20")
        }
    }
}

android {
    namespace = "com.safelink.app"
    compileSdk = libs.versions.android.compileSdk.get().toInt()

    val keystoreProperties = Properties()
    val localPropertiesFile = project.rootProject.file("local.properties")
    if (localPropertiesFile.exists()) {
        localPropertiesFile.inputStream().use { keystoreProperties.load(it) }
    }

    fun getProp(name: String): String? = keystoreProperties.getProperty(name) ?: System.getenv(name)

    val keyAlias = getProp("keyAlias")
    val keyPassword = getProp("keyPassword")
    val storePassword = getProp("storePassword")
    val storeFilePath = getProp("storeFile")

    val hasSigningConfigs = keyAlias != null && keyPassword != null && storePassword != null && storeFilePath != null
    
    if (hasSigningConfigs) {
        signingConfigs {
            create("release") {
                this.keyAlias = keyAlias
                this.keyPassword = keyPassword
                this.storePassword = storePassword
                this.storeFile = file(storeFilePath!!)
            }
        }
    }

    defaultConfig {
        applicationId = "com.safelink.app"
        minSdk = libs.versions.android.minSdk.get().toInt()
        targetSdk = libs.versions.android.targetSdk.get().toInt()
        versionCode = 3
        versionName = "2.1.0"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            if (hasSigningConfigs) {
                signingConfig = signingConfigs.getByName("release")
            }
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

compose.desktop {
    application {
        mainClass = "com.safelink.app.MainKt"

        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb, TargetFormat.Exe)
            packageName = "SafeLink"
            packageVersion = "2.3.1"
            
            // Use ARM64 JDK for native Windows ARM64 support
            javaHome = "C:/Program Files/Microsoft/jdk-21.0.9.10-hotspot"
            
            // Bundle complete JDK runtime for SQLDelight JDBC compatibility
            includeAllModules = true
            
            // Enable console for debugging JVM launch issues
            windows {
                console = true
            }
        }
        buildTypes.release.proguard {
            version.set("7.5.0")
            isEnabled.set(false) // Disabled: Proguard strips Koin DI reflection
        }
    }
}
