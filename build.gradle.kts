plugins {
    // this is necessary to avoid the plugins to be loaded multiple times
    // in each subproject's classloader
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.androidLibrary) apply false
    alias(libs.plugins.composeHotReload) apply false
    alias(libs.plugins.composeMultiplatform) apply false
    alias(libs.plugins.composeCompiler) apply false
    alias(libs.plugins.kotlinMultiplatform) apply false
    alias(libs.plugins.ktlint) apply false
    alias(libs.plugins.detekt)
    alias(libs.plugins.module.graph) apply true // Plugin applied to allow module graph generation
    alias(libs.plugins.android.kotlin.multiplatform.library) apply false
    alias(libs.plugins.android.lint) apply false
}

subprojects {
    apply(plugin = "org.jlleitschuh.gradle.ktlint")
    configure<org.jlleitschuh.gradle.ktlint.KtlintExtension> {
        debug.set(true)
    }
}


allprojects {
    apply(plugin = "dev.detekt")
    detekt {
        buildUponDefaultConfig = true
        config.setFrom(files("${rootProject.projectDir}/detekt/detekt-config.yml"))
        source.setFrom(getDetektSourcePaths())
    }
}

private fun getDetektSourcePaths(): List<File> {
    val sourceDirs = mutableListOf<File>()

    subprojects.forEach {
        sourceDirs.add(file("${it.projectDir}/src/commonMain/kotlin"))
        sourceDirs.add(file("${it.projectDir}/src/androidMain/kotlin"))
        sourceDirs.add(file("${it.projectDir}/src/iosMain/kotlin"))
        sourceDirs.add(file("${it.projectDir}/src/jsMain/kotlin"))
        sourceDirs.add(file("${it.projectDir}/src/jvmMain/kotlin"))
        sourceDirs.add(file("${it.projectDir}/src/wasmJsMain/kotlin"))
        sourceDirs.add(file("${it.projectDir}/src/webMain/kotlin"))
    }

    return sourceDirs.filter { it.exists() }
}