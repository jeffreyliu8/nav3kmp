import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.android.kotlin.multiplatform.library)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
    alias(libs.plugins.kotlinxSerialization)
    alias(libs.plugins.koin.compiler)
    alias(libs.plugins.detekt)
}

kotlin {
    androidLibrary {
        compileSdk = libs.versions.android.compileSdk.get().toInt()
        minSdk = libs.versions.android.minSdk.get().toInt()
        namespace = "com.jeffliu.nav3kmp"
        experimentalProperties["android.experimental.kmp.enableAndroidResources"] = true
    }

    listOf(
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "ComposeApp"
            isStatic = true
        }
    }

    jvm()

//    js {
//        browser()
//        binaries.executable()
//    }
//
//    @OptIn(ExperimentalWasmDsl::class)
//    wasmJs {
//        browser()
//        binaries.executable()
//    }

    sourceSets {
        androidMain.dependencies {
            api(libs.compose.uiToolingPreview)
            api(libs.androidx.activity.compose)
        }
        commonMain.dependencies {
            implementation(libs.compose.components.resources)

            implementation(libs.androidx.lifecycle.viewmodelCompose)
            implementation(libs.androidx.lifecycle.runtimeCompose)
            implementation(libs.androidx.lifecycle.viewmodel.nav3)

            implementation(projects.core.data)
            implementation(projects.core.designsystem)

            implementation(libs.adaptive)
            implementation(libs.adaptive.navigation)
        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
    }
}

// android {
//    namespace = "com.jeffliu.nav3kmp"
//    compileSdk = libs.versions.android.compileSdk.get().toInt()
//
//    defaultConfig {
//        applicationId = "com.jeffliu.nav3kmp"
//        minSdk = libs.versions.android.minSdk.get().toInt()
//        targetSdk = libs.versions.android.targetSdk.get().toInt()
//        versionCode = 1
//        versionName = "1.0"
//    }
//    packaging {
//        resources {
//            excludes += "/META-INF/{AL2.0,LGPL2.1}"
//        }
//    }
//    buildTypes {
//        getByName("release") {
//            isMinifyEnabled = true
//            proguardFiles(
//                getDefaultProguardFile("proguard-android-optimize.txt"),
//                "proguard-rules.pro"
//            )
//        }
//    }
//    compileOptions {
//        sourceCompatibility = JavaVersion.VERSION_17
//        targetCompatibility = JavaVersion.VERSION_17
//    }
// }
//
// dependencies {
//    debugImplementation(libs.compose.uiTooling)
// }

compose.desktop {
    application {
        mainClass = "com.jeffliu.nav3kmp.MainKt"

        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "com.jeffliu.nav3kmp"
            packageVersion = "1.0.0"
        }
    }
}

allprojects {
    apply(plugin = "dev.detekt")
    detekt {
        toolVersion = "2.0.0-alpha.2"
        config.setFrom(files("${rootProject.projectDir}/detekt/detekt-config.yml"))
        buildUponDefaultConfig = true
    }
}
