plugins {
    id("java")
    id("org.springframework.boot") version "2.7.8"
}

apply(plugin = "io.spring.dependency-management")

group "ru.itis"
version "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {


    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.postgresql:postgresql:42.5.3")
// https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-validation
    implementation("org.springframework.boot:spring-boot-starter-validation:3.0.2")

    compileOnly ("org.projectlombok:lombok:1.18.26")
    annotationProcessor ("org.projectlombok:lombok:1.18.26")

    testCompileOnly ("org.projectlombok:lombok:1.18.26")
    testAnnotationProcessor ("org.projectlombok:lombok:1.18")

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}