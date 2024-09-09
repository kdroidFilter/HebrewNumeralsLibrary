# Gematria Calculator

## Overview

The Gematria Calculator is a Kotlin function that converts a numerical value into its corresponding Hebrew gematria string. This function is designed to handle years in the Hebrew calendar within the current millennium, omitting the thousands digit.

## Features

- Converts integers to Hebrew gematria strings.
- Handles years within the current millennium.
- Omits the thousands digit in the output.
- Allowing compilation to native binaries for various platforms, including JVM, JS, and native platforms.

### Build platform artifacts

#### Android aar

- Run `./gradlew :gematria:assembleRelease`
- Output: `/gematria/build/outputs/aar/gematria-release.aar`

#### JVM jar

- Run `./gradlew :gematria:jvmJar`
- Output: `/gematria/build/libs/gematria-jvm-1.0.jar`

#### iOS Framework

- Run `./gradlew :gematria:linkReleaseFrameworkIosArm64`
- Output: `/gematria/build/bin/iosArm64/releaseFramework/gematria.framework`

#### JS file

- Run `./gradlew :gematria:jsBrowserProductionWebpack`
- Output: `/gematria/build/dist/js/productionExecutable/gematria.js`

#### macOS Framework

- Run `./gradlew :gematria:linkReleaseFrameworkMacosArm64`
- Output: `/gematria/build/bin/macosArm64/releaseFramework/gematria.framework`

#### Linux static library

- Run `./gradlew :gematria:linkReleaseStaticLinuxX64`
- Output: `/gematria/build/bin/linuxX64/releaseStatic/libgematria.a`

#### Windows static library

- Run `./gradlew :gematria:linkReleaseStaticMingwX64`
- Output: `/gematria/build/bin/mingwX64/releaseStatic/libgematria.a`

#### Wasm binary file

- Run `./gradlew :gematria:wasmJsBrowserDistribution`
- Output: `/gematria/build/dist/wasmJs/productionExecutable/gematria-wasm-js.wasm`
