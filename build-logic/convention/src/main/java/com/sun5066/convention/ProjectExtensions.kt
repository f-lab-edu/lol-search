package com.sun5066.convention

import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalog
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.getByType

val Project.libs: VersionCatalog
    get() = extensions.getByType<VersionCatalogsExtension>().named("libs")

val Project.targetSdkVersions: Int
    get() = libs.findVersion("targetSdkVersions").get().toString().toInt()

val Project.minSdkVersions: Int
    get() = libs.findVersion("minSdkVersions").get().toString().toInt()