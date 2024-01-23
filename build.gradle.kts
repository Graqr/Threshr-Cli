plugins {
    id("groovy") 
    id("com.github.johnrengelman.shadow") version "8.1.1"
    id("io.micronaut.application") version "4.0.3"
    id("com.google.cloud.tools.jib") version "2.8.0"
    id("org.asciidoctor.jvm.convert") version "3.3.2"
}

version = "0.1"
group = "com.graqr"

apply(from="gradle/asciidoc.gradle")
repositories {
    mavenCentral()
}

dependencies {
    annotationProcessor("io.micronaut.data:micronaut-data-processor")
    annotationProcessor("info.picocli:picocli-codegen")
    annotationProcessor("io.micronaut.serde:micronaut-serde-processor")
    annotationProcessor("io.micronaut.validation:micronaut-validation-processor")
    implementation("info.picocli:picocli")
    implementation("io.micronaut.data:micronaut-data-jdbc")
    implementation("io.micronaut.picocli:micronaut-picocli")
    implementation("io.micronaut.serde:micronaut-serde-jackson")
    implementation("io.micronaut.sql:micronaut-jdbc-hikari")
    implementation("io.micronaut.validation:micronaut-validation")
    implementation("jakarta.validation:jakarta.validation-api")
    compileOnly("org.graalvm.nativeimage:svm")
    runtimeOnly("com.h2database:h2")
    runtimeOnly("org.slf4j:slf4j-simple")
    runtimeOnly("org.yaml:snakeyaml")
}


application {
    mainClass.set("com.graqr.ThreshrCliCommand")
}
java {
    sourceCompatibility = JavaVersion.toVersion("17")
    targetCompatibility = JavaVersion.toVersion("17")
}

tasks {
    jib {
        to {
            image = "gcr.io/myapp/jib-image"
        }
    }
}
micronaut {
    testRuntime("spock2")
    processing {
        incremental(true)
        annotations("com.graqr.*")
    }
}



