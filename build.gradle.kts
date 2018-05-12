plugins {
    java
}

group = "xBlueCode"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}


dependencies {
    testCompile("org.junit.jupiter", "junit-jupiter-api", "5.2.0")
    testCompile("org.junit.jupiter", "junit-jupiter-engine", "5.2.0")

    //testCompile("org.junit.jupiter:junit-jupiter-params:5.1.0")
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
}
