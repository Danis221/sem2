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
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
    implementation ("org.springframework.boot:spring-boot-starter-mail")

    implementation ("org.thymeleaf.extras:thymeleaf-extras-springsecurity5:3.0.4.RELEASE")
    implementation ("org.thymeleaf:thymeleaf-spring5:3.0.15.RELEASE")


    implementation("org.postgresql:postgresql:42.5.3")
 
    compileOnly ("org.projectlombok:lombok:1.18.26")
    annotationProcessor ("org.projectlombok:lombok:1.18.26")

    testCompileOnly ("org.projectlombok:lombok:1.18.26")
    testAnnotationProcessor ("org.projectlombok:lombok:1.18")

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")

    implementation ("javax.mail:javax.mail-api:1.6.2")

    //webjars
    implementation ("org.webjars:jquery:3.6.0")
    implementation ("org.webjars:bootstrap:4.6.0")
    implementation ("org.webjars:webjars-locator-core:0.46")

    annotationProcessor ("org.springframework.boot:spring-boot-configuration-processor")

}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}