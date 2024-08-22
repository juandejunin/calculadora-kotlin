import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.8.21"
    application
    id("org.jetbrains.compose") version "1.5.0"  // Agrega el plugin de Compose
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(compose.desktop.currentOs)
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "17"
}

application {
    mainClass.set("MainKt")
}

tasks.jar {
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE

    manifest {
        attributes["Main-Class"] = "MainKt"
    }

    from({
        configurations.runtimeClasspath.get().filter { it.exists() }.map { zipTree(it) }
    })

    exclude("META-INF/versions/9/module-info.class") // Excluir el archivo específico que causa el conflicto
}
