import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {

	repositories {
		mavenCentral()
	}

	dependencies.classpath("org.jfrog.buildinfo:build-info-extractor-gradle:4.17.0")
	dependencies.classpath("gradle.plugin.com.gorylenko.gradle-git-properties:gradle-git-properties:2.2.3")
	dependencies.classpath("org.springframework.boot:spring-boot-gradle-plugin:2.4.1")
}

plugins {
	id("org.springframework.boot") version "2.4.1"
	id("io.spring.dependency-management") version "1.0.9.RELEASE"
	id("com.jfrog.artifactory") version "4.17.0"

	kotlin("jvm") version "1.4.10"
	kotlin("plugin.spring") version "1.4.10"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
	mavenCentral()
}

dependencyManagement {
	applyMavenExclusions(false)
}

configurations.all {
	exclude("commons-logging")
}

dependencies {
	//Spring
	implementation("org.springframework.boot:spring-boot-starter-actuator")
	implementation("org.springframework.boot:spring-boot-starter-web")

	//Kotlin
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

	//Utils
	implementation("commons-io:commons-io:2.8.0")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")

	//Test
	testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "1.8"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
