plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:6.0.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    implementation("org.seleniumhq.selenium:selenium-java:4.45.0")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.18.2")

    // Source: https://mvnrepository.com/artifact/org.testng/testng
    testImplementation("org.testng:testng:7.12.0")
    implementation("io.rest-assured:rest-assured:5.5.0")

    // Source: https://mvnrepository.com/artifact/org.hamcrest/hamcrest
    implementation("org.hamcrest:hamcrest:3.0")
    // Source: https://mvnrepository.com/artifact/io.qameta.allure/allure-testng
    implementation("io.qameta.allure:allure-testng:3.0.1")
}

tasks.test {
//    useJUnitPlatform()
    useTestNG()
}