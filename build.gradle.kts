plugins {
    id("java")
    id("io.qameta.allure") version "4.3.0"
}

group = "localhost"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.seleniumhq.selenium:selenium-java:4.45.0")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.18.2")
    testImplementation("org.testng:testng:7.12.0")
    implementation("io.rest-assured:rest-assured:5.5.0")
    implementation("org.hamcrest:hamcrest:3.0")
}


//java {
//    toolchain {
//        languageVersion.set(JavaLanguageVersion.of(21))
//    }
//}

tasks.test {
    useTestNG()

    val env = System.getProperty("env") ?: System.getenv("TEST_ENV") ?: "qa"
    systemProperty("env", env)

    val baseUrl = System.getProperty("baseUrl") ?: System.getenv("BASE_URL")
    if (baseUrl != null) {
        systemProperty("baseUrl", baseUrl)
    }

    testLogging {
        events("passed", "skipped", "failed")
        exceptionFormat = org.gradle.api.tasks.testing.logging.TestExceptionFormat.SHORT
    }
}

val allureVersion = "2.27.0"

allure {
    version.set(allureVersion)
//    adapter {
//        autoconfigure.set(true)
//        aspectjWeaver.set(true)
//        frameworks {
//            testng {
//                adapterVersion.set(allureVersion)
//            }
//        }
//    }
}


tasks.withType<JavaCompile>().configureEach {
    options.encoding = "UTF-8"
}