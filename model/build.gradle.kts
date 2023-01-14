import com.google.protobuf.gradle.*

plugins {
	kotlin("jvm") version "1.7.22"
	kotlin("plugin.spring") version "1.7.22"
	id("com.google.protobuf") version "0.9.2"
}

group = "leon.patmore"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17


repositories {
	mavenCentral()
}

dependencies {
	api("com.google.protobuf:protobuf-kotlin:3.21.12")
	protobuf(files("proto/"))
}

protobuf {
	protoc {
		artifact = "com.google.protobuf:protoc:3.21.12"
	}
	generateProtoTasks {
		ofSourceSet("main").forEach {
			it.builtins {
				id("kotlin")
			}
		}
	}
}
