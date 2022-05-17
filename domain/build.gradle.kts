plugins {
    kotlin("jvm")
}
java {
    sourceCompatibility = JavaVersion.VERSION_1_7
    targetCompatibility = JavaVersion.VERSION_1_7
}

dependencies {
    api(libs.javax.inject)
    implementation(libs.coroutines.core)
}