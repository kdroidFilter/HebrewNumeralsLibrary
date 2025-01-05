# 📚 Hebrew Numerals Library

This library provides a set of Kotlin functions for working with Hebrew numerals (Gematria) and Talmudic page references (Daf Gemara). It's designed to be easy to use and integrate into your projects, offering convenient extensions for String and Int types.

## ✨ Features

- Convert Hebrew strings to their numerical Gematria value
- Convert integers to Hebrew numeral representations (Gematria)
- Convert Daf Gemara (Talmudic page) numbers to their string representations
- Multiplatform support: can be used on JVM, JS, and Native platforms
- Exportable as both a native library and a JavaScript library
- **Available on Maven Central**

## 📥 Importing the Library

You can import the library directly from Maven Central.

### 🛠️ Gradle

Add the following to your `build.gradle.kts`:

```kotlin
repositories {
    mavenCentral()
}

dependencies {
    implementation("io.github.kdroidfilter:hebrewnumerals:0.2.4")
}
```

## 🚀 Usage

### 🔢 Converting Hebrew String to Gematria

```kotlin
val hebrewYear = "תשפִד"
val gematriaValue = hebrewYear.toGematria()
println(gematriaValue) // Outputs: 784
```

### 📜 Converting Integer to Daf Gemara

```kotlin
val dafNumber = 5
val dafGemara = dafNumber.toDafGemara()
println(dafGemara) // Outputs: "ד."

val dafNumber2 = 6
val dafGemara2 = dafNumber2.toDafGemara()
println(dafGemara2) // Outputs: "ד:"
```

### 🔠 Converting Integer to Hebrew Numeral

```kotlin
val year = 5784
val hebrewYear = year.toHebrewNumeral()
println(hebrewYear) // Outputs: "ה'תשפ"ד"

// Without Geresh symbols
val hebrewYearNoSymbols = year.toHebrewNumeral(includeGeresh = false)
println(hebrewYearNoSymbols) // Outputs: "התשפד"
```

### 🔤 Converting Integer to English Daf Gemara

```kotlin
val dafNumber = 5
val englishDaf = dafNumber.toEnglishDafGemara()
println(englishDaf) // Outputs: "4a"

val dafNumber2 = 6
val englishDaf2 = dafNumber2.toEnglishDafGemara()
println(englishDaf2) // Outputs: "4b"
```

## 🌐 Multiplatform Support

This library is built with Kotlin Multiplatform, allowing it to be used across different platforms:

- JVM: For use in Java and Android applications
- JS: For use in web applications and Node.js environments
- Native: For use in iOS, desktop, and other native applications

## 📖 API Reference

### `String.toGematria(): Int`

Converts a Hebrew string to its corresponding numerical value (Gematria).

### `Int.toDafGemara(): String`

Converts an integer representing a Daf Gemara (Talmudic page) to its corresponding string representation.

### `Int.toHebrewNumeral(includeGeresh: Boolean = true): String`

Converts an integer to its corresponding Hebrew numeral representation (Gematria).

### `Int.toEnglishDafGemara(): String`

Converts an integer representing a Daf Gemara to its English representation with "a" (Aleph) and "b" (Bet).

## 🛠️ Exporting as Native or JS Library

The library can be easily exported for use in various environments:

- As a native library: Can be compiled and used in C, Objective-C, and Swift projects
- As a JavaScript library: Can be used directly in web applications or Node.js projects

