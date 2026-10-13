plugins {
    id("java-library")
    alias(libs.plugins.jetbrains.kotlin.jvm)
}
java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}
kotlin {
    compilerOptions {
        jvmTarget = org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_11
    }
    //forzar la codificación UTF-8 en las tareas de ejecución
    tasks.matching { it.name.endsWith(".main") }.configureEach {
        if (this is JavaExec) {
            systemProperty("file.encoding", "UTF-8")
            systemProperty("sun.stdout.encoding", "UTF-8")
            systemProperty("sun.stderr.encoding", "UTF-8")
        }
    }
}
