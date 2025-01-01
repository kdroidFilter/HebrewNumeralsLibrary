import com.vanniktech.maven.publish.SonatypeHost
import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl

plugins {
    alias(libs.plugins.multiplatform)
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlinx.serialization)
    id("com.vanniktech.maven.publish") version "0.30.0"
}

group = "com.kdroid.gematria"
version = "0.2.2"



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

mavenPublishing {
    coordinates(
        groupId = "io.github.kdroidfilter",
        artifactId = "hebrewnumerals",
        version = version.toString()
    )

    pom {
        name.set("Hebrew Numerals Library")
        description.set(
            "A Kotlin library that provides functions for Hebrew numerals (Gematria) and Talmudic page references (Daf Gemara). " +
                    "Supports conversion of Hebrew strings to Gematria values, integers to Hebrew numeral representations, " +
                    "and Daf Gemara page numbers. Built with Kotlin Multiplatform for JVM, JS, and Native platforms."
        )
        inceptionYear.set("2024")
        url.set("https://github.com/kdroidFilter/HebrewNumeralsLibrary")

        licenses {
            license {
                name.set("MIT License")
                url.set("https://opensource.org/licenses/MIT")
            }
        }

        developers {
            developer {
                id.set("kdroidfilter")
                name.set("Elyahou Hadass")
                email.set("elyahou.hadass@gmail.com")
            }
        }

        scm {
            connection.set("scm:git:https://github.com/kdroidFilter/HebrewNumeralsLibrary.git")
            developerConnection.set("scm:git:https://github.com/kdroidFilter/HebrewNumeralsLibrary.git")
            url.set("https://github.com/kdroidFilter/HebrewNumeralsLibrary ")
        }
    }

    publishToMavenCentral(SonatypeHost.CENTRAL_PORTAL)

    signAllPublications()
}


android {
    namespace = "com.kdroid.gematria"
    compileSdk = 34

    defaultConfig {
        minSdk = 21
    }
}
