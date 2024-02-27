/*
 * Copyright (c) 2023 Matthias Geisler (bitPogo) / All rights reserved.
 *
 * Use of this source code is governed by Apache v2.0
 */

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    repositories {
        val antibytesPlugins = "^tech\\.antibytes\\.[\\.a-z\\-]+"
        gradlePluginPortal()
        google()
        mavenCentral()
        maven {
            setUrl("https://raw.github.com/bitPogo/maven-snapshots/main/snapshots")
            content {
                includeGroupByRegex(antibytesPlugins)
            }
        }
        maven {
            setUrl("https://raw.github.com/bitPogo/maven-rolling-releases/main/rolling")
            content {
                includeGroupByRegex(antibytesPlugins)
            }
        }
    }
}

plugins {
    id("tech.antibytes.gradle.dependency.settings") version "2ebcd5b"
}

dependencyResolutionManagement {
    versionCatalogs {
        getByName("antibytesCatalog") {
            version("minSdk", "21")
            version("kfixture", "0.4.0-SNAPSHOT")
            version("testUtils", "86ec4d6")
            version("kmock", "0.3.0-rc08-SNAPSHOT")
            version("kotlinx-coroutines-core", "1.7.1")
            version("kotlinx-coroutines-test", "1.7.1")
            version("google-android-playservice-location", "21.1.0")
            version("vico", "1.14.0")

            library("kfixture", "tech.antibytes.kfixture", "core").versionRef("kfixture")
            library("testUtils-core", "tech.antibytes.test-utils-kmp", "test-utils").versionRef("testUtils")
            library(
                "testUtils-annotations",
                "tech.antibytes.test-utils-kmp",
                "test-utils-annotations-junit4",
            ).versionRef("testUtils")
            library(
                "testUtils-coroutine",
                "tech.antibytes.test-utils-kmp",
                "test-utils-coroutine",
            ).versionRef("testUtils")
            library(
                "testUtils-ktor",
                "tech.antibytes.test-utils-kmp",
                "test-utils-ktor",
            ).versionRef("testUtils")
            library(
                "testUtils-resourceloader",
                "tech.antibytes.test-utils-kmp",
                "test-utils-resourceloader",
            ).versionRef("testUtils")
            library(
                "kmock",
                "tech.antibytes.kmock",
                "kmock",
            ).versionRef("kmock")
            plugin("kmock", "tech.antibytes.kmock.kmock-gradle").versionRef("kmock")
            library(
                "android-google-android-playservice-location",
                "com.google.android.gms",
                "play-services-location",
            ).versionRef("google-android-playservice-location")
            library(
                "vico-compose-core",
                "com.patrykandpatrick.vico",
                "compose",
            ).versionRef("vico")
            library(
                "vico-compose-m2",
                "com.patrykandpatrick.vico",
                "compose-m2",
            ).versionRef("vico")
            library(
                "vico-compose-m3",
                "com.patrykandpatrick.vico",
                "compose-m3",
            ).versionRef("vico")
            library(
                "vico-core",
                "com.patrykandpatrick.vico",
                "core",
            ).versionRef("vico")
            library(
                "vico-views",
                "com.patrykandpatrick.vico",
                "views",
            ).versionRef("vico")
            library(
                "compose-material3",
                "androidx.compose.material3",
                "material3",
            ).version("1.2.0")
        }
    }
}

includeBuild("setup")

include(
    ":kmp-lib",
    ":example-android-application",
)

buildCache {
    //   fullCache(rootDir)
}

rootProject.name = "template-project"
