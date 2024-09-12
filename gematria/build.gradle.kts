import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl

plugins {
    alias(libs.plugins.multiplatform)
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlinx.serialization)
    id("convention.publication")
    id("maven-publish")
}

group = "com.kdroid.gematria"
version = "0.1.1"

publishing {
    publications {
        // Publication pour la bibliothèque multiplateforme
        create<MavenPublication>("maven") {
            // Configuration des coordonnées du projet
            groupId = project.group.toString()
            artifactId = "gematria"
            version = project.version.toString()

            from(components["kotlin"])

            pom {
                name.set("Hebrew Numerals Library")
                description.set("A set of Kotlin functions for working with Hebrew numerals")
                url.set("https://github.com/kdroidFilter/HebrewNumeralsLibrary")
            }
        }
    }
    repositories {
        mavenLocal()
        maven {
            name = "reposilite"
            url = uri("http://85.130.160.209:8080/releases")
            credentials{
                username = System.getenv("MAVEN_USER")
                password = System.getenv("MAVEN_PASSWORD")
            }
            authentication {
                create<BasicAuthentication>("basic")
            }
            isAllowInsecureProtocol = true
        }
    }
}

kotlin {
    jvmToolchain(11)
    androidTarget {
        publishLibraryVariants("release")
    }

    jvm()

    js {
        browser {
            webpackTask {
                mainOutputFileName = "gematria.js"
            }
        }
        binaries.executable()
    }

    @OptIn(ExperimentalWasmDsl::class)
    wasmJs {
        browser()
        binaries.executable()
    }

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "gematria"
            isStatic = true
        }
    }

    listOf(
        macosX64(),
        macosArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "gematria"
            isStatic = true
        }
    }

    linuxX64 {
        binaries.staticLib {
            baseName = "gematria"
        }
    }


    mingwX64 {
        binaries.staticLib {
            baseName = "gematria"
        }
    }

    sourceSets {
        commonMain.dependencies {
            implementation(libs.kotlinx.serialization.json)
            implementation(libs.kotlinx.datetime)
        }

        commonTest.dependencies {
            implementation(kotlin("test"))
        }

    }

    //https://kotlinlang.org/docs/native-objc-interop.html#export-of-kdoc-comments-to-generated-objective-c-headers
    targets.withType<org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget> {
        compilations["main"].compilerOptions.options.freeCompilerArgs.add("-Xexport-kdoc")
    }

}

android {
    namespace = "com.kdroid.gematria"
    compileSdk = 34

    defaultConfig {
        minSdk = 21
    }
}
