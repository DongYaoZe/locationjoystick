plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.jvm) apply false
    alias(libs.plugins.kotlin.serialization) apply false
    alias(libs.plugins.kotlin.compose) apply false
    alias(libs.plugins.hilt) apply false
    alias(libs.plugins.ksp) apply false
    alias(libs.plugins.kover)
    alias(libs.plugins.ktlint)
}

val needsAsciiWindowsBuildDir =
    System.getProperty("os.name").startsWith("Windows", ignoreCase = true) &&
        rootProject.projectDir.absolutePath.any { it.code > 0x7F }

if (needsAsciiWindowsBuildDir) {
    val safeBuildRoot = file("D:/Documents/_build-cache/OpenLocation")
    layout.buildDirectory.set(safeBuildRoot.resolve("_root"))

    subprojects {
        val relativeProjectPath = path.removePrefix(":").replace(':', '/')
        layout.buildDirectory.set(safeBuildRoot.resolve(relativeProjectPath))
    }
}

subprojects {
    apply(plugin = "org.jlleitschuh.gradle.ktlint")
}

dependencies {
    kover(project(":app"))
    kover(project(":core:common"))
    kover(project(":core:data"))
    kover(project(":core:map"))
    kover(project(":core:database"))
    kover(project(":core:datastore"))
    kover(project(":core:designsystem"))
    kover(project(":core:location"))
    kover(project(":core:model"))
    kover(project(":core:overlay"))
    kover(project(":core:routing"))
    kover(project(":core:testing"))
    kover(project(":feature:favorites:api"))
    kover(project(":feature:favorites:impl"))
    kover(project(":feature:joystick:impl"))
    kover(project(":feature:map:api"))
    kover(project(":feature:map:impl"))
    kover(project(":feature:routes:api"))
    kover(project(":feature:routes:impl"))
    kover(project(":feature:settings:api"))
    kover(project(":feature:settings:impl"))
    kover(project(":feature:onboarding:api"))
    kover(project(":feature:onboarding:impl"))
    kover(project(":feature:widget:impl"))
}
