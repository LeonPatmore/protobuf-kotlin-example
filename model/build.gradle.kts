import com.google.protobuf.gradle.*
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	kotlin("jvm") version "1.7.22"
	kotlin("plugin.spring") version "1.7.22"
	id("com.google.protobuf") version "0.9.2"
}

group = "leon.patmore"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17


sourceSets {
	main {
		proto {
			srcDir("src/main/proto")
		}
	}
}

repositories {
	mavenCentral()
}

dependencies {
	api("com.google.protobuf:protobuf-java:3.21.12")
	protobuf(files("proto/"))
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "17"
	}
}

protobuf {
	protoc {
		artifact = "com.google.protobuf:protoc:3.21.12"
	}
	plugins {
		id("grpckt") {
			artifact = "io.grpc:protoc-gen-grpc-kotlin:1.3.0:jdk8@jar"
		}
	}
	generateProtoTasks {
		ofSourceSet("main").forEach {
			it.plugins {
				id("grpckt")
			}
			it.builtins {
				id("kotlin")
			}
		}
	}
}
