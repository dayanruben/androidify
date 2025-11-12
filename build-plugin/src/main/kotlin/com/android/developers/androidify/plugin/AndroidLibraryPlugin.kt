package com.android.developers.androidify.plugin

import com.android.build.api.dsl.LibraryExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.assign
import org.gradle.kotlin.dsl.configure
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.dsl.KotlinAndroidProjectExtension

class AndroidLibraryPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        with(project) {
            apply(plugin = "com.android.library")
            apply(plugin = "org.jetbrains.kotlin.android")

            extensions.configure<LibraryExtension> {
                compileSdk = getVersionByName("compileSdk").toInt()
                defaultConfig {
                    minSdk = getVersionByName("minSdk").toInt()
                }
                compileOptions {
                    val javaVersion = JavaVersion.toVersion(getVersionByName("javaVersion"))
                    sourceCompatibility = javaVersion
                    targetCompatibility = javaVersion
                }
                testOptions {
                    targetSdk = getVersionByName("targetSdk").toInt()
                }
                lint {
                    targetSdk = getVersionByName("targetSdk").toInt()
                }
            }
            extensions.configure<KotlinAndroidProjectExtension> {
                compilerOptions {
                    jvmTarget = JvmTarget.fromTarget(getVersionByName("jvmTarget"))
                }
            }
        }
    }
}
