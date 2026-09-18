import com.google.gms.googleservices.GoogleServicesPlugin.MissingGoogleServicesStrategy
import java.util.Properties

plugins {
  id("org.jetbrains.kotlin.plugin.serialization")
  alias(libs.plugins.android.application)
  alias(libs.plugins.kotlin.compose)
  alias(libs.plugins.google.devtools.ksp)
  alias(libs.plugins.roborazzi)
  alias(libs.plugins.google.services)
}

val signingProperties = Properties().apply {
  rootProject.file("keystore.properties").takeIf { it.isFile }?.inputStream()?.use { load(it) }
}
fun signingValue(property: String, environment: String): String? =
  signingProperties.getProperty(property)?.takeIf { it.isNotBlank() }
    ?: System.getenv(environment)?.takeIf { it.isNotBlank() }
val releaseStore = signingValue("storeFile", "KEYSTORE_PATH")
val releasePassword = signingValue("storePassword", "STORE_PASSWORD")
val releaseAlias = signingValue("keyAlias", "KEY_ALIAS")
val releaseKeyPassword = signingValue("keyPassword", "KEY_PASSWORD")
val releaseSigningReady = listOf(releaseStore, releasePassword, releaseAlias, releaseKeyPassword).all { it != null }
val localConfiguration = Properties().apply {
  rootProject.file("local.properties").takeIf { it.isFile }?.inputStream()?.use { load(it) }
}
fun configString(name: String): String = System.getenv(name)?.takeIf { it.isNotBlank() }
  ?: localConfiguration.getProperty(name).orEmpty()
fun quoted(value: String): String = "\"" + value.replace("\\", "\\\\").replace("\"", "\\\"").replace("\n", "\\n") + "\""

android {
  namespace = "com.example"
  compileSdk { version = release(36) { minorApiLevel = 1 } }

  defaultConfig {
    applicationId = "com.aistudio.tripplanner.kvxwq"
    minSdk = 24
    targetSdk = 36
    versionCode = 7
    versionName = "2.4"
    buildConfigField("String", "GOOGLE_WEB_CLIENT_ID", quoted(configString("GOOGLE_WEB_CLIENT_ID")))
    buildConfigField("String", "MAPS_ANDROID_KEY", quoted(configString("MAPS_ANDROID_KEY")))
    manifestPlaceholders["mapsApiKey"] = configString("MAPS_ANDROID_KEY")

    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
  }

  signingConfigs {
    create("release") {
      if (releaseSigningReady) {
        storeFile = rootProject.file(requireNotNull(releaseStore))
        storePassword = releasePassword
        keyAlias = releaseAlias
        keyPassword = releaseKeyPassword
      }
    }
  }

  buildTypes {
    release {
      isCrunchPngs = false
      isMinifyEnabled = true
      isShrinkResources = true
      proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
      signingConfig = signingConfigs.getByName("release")
    }
    // Use Android's standard debug keystore; the export does not contain debug.keystore.
  }
  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
  }
  buildFeatures {
    compose = true
    buildConfig = true
  }
  testOptions { unitTests { isIncludeAndroidResources = true } }
  dependenciesInfo {
    includeInApk = false
    includeInBundle = true
  }
}

googleServices { missingGoogleServicesStrategy = MissingGoogleServicesStrategy.WARN }
ksp { arg("room.schemaLocation", "$projectDir/schemas") }
val validateReleaseSigning by tasks.registering {
  doLast {
    check(releaseSigningReady) { "Release signing requires keystore.properties or all four signing environment variables." }
    check(rootProject.file(requireNotNull(releaseStore)).isFile) { "Release keystore file is missing." }
  }
}
tasks.configureEach {
  if (name == "preReleaseBuild") dependsOn(validateReleaseSigning)
}

dependencies {
  implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.8.1")
  implementation("org.jetbrains.kotlinx:kotlinx-coroutines-play-services:1.10.2")
  implementation(libs.androidx.datastore.preferences)
  implementation(libs.firebase.auth)
  implementation(libs.firebase.firestore)
  implementation("com.google.firebase:firebase-functions")
  implementation("com.google.firebase:firebase-appcheck-playintegrity")
  implementation(libs.androidx.credentials)
  implementation(libs.androidx.credentials.play.services)
  implementation(libs.googleid)
  implementation(libs.play.services.location)
  implementation("com.google.maps.android:maps-compose:6.4.1")
  implementation("com.google.android.libraries.places:places:4.1.0")
  implementation("com.android.billingclient:billing-ktx:8.0.0")
  implementation(platform(libs.androidx.compose.bom))
  implementation(platform(libs.firebase.bom))
  implementation(libs.androidx.activity.compose)
  implementation(libs.androidx.compose.material.icons.core)
  implementation(libs.androidx.compose.material.icons.extended)
  implementation(libs.androidx.compose.material3)
  implementation(libs.androidx.compose.ui)
  implementation(libs.androidx.compose.ui.graphics)
  implementation(libs.androidx.compose.ui.tooling.preview)
  implementation(libs.androidx.core.ktx)
  implementation(libs.androidx.lifecycle.runtime.compose)
  implementation(libs.androidx.lifecycle.runtime.ktx)
  implementation(libs.androidx.lifecycle.viewmodel.compose)
  implementation(libs.androidx.navigation.compose)
  implementation(libs.androidx.room.ktx)
  implementation(libs.androidx.room.runtime)
  implementation(libs.coil.compose)
  implementation(libs.converter.moshi)
  implementation(libs.firebase.appcheck.debug)
  implementation(libs.kotlinx.coroutines.android)
  implementation(libs.kotlinx.coroutines.core)
  implementation(libs.logging.interceptor)
  implementation(libs.moshi.kotlin)
  implementation(libs.okhttp)
  implementation(libs.retrofit)
  testImplementation(libs.androidx.compose.ui.test.junit4)
  testImplementation(libs.androidx.core)
  testImplementation(libs.androidx.junit)
  testImplementation(libs.junit)
  testImplementation(libs.kotlinx.coroutines.test)
  testImplementation(libs.robolectric)
  testImplementation(libs.roborazzi)
  testImplementation(libs.roborazzi.compose)
  testImplementation(libs.roborazzi.junit.rule)
  androidTestImplementation(platform(libs.androidx.compose.bom))
  androidTestImplementation(libs.androidx.compose.ui.test.junit4)
  androidTestImplementation(libs.androidx.espresso.core)
  androidTestImplementation(libs.androidx.junit)
  androidTestImplementation(libs.androidx.runner)
  debugImplementation(libs.androidx.compose.ui.test.manifest)
  debugImplementation(libs.androidx.compose.ui.tooling)
  "ksp"(libs.androidx.room.compiler)
  "ksp"(libs.moshi.kotlin.codegen)
}
