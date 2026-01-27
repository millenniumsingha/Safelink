plugins {
    // this is necessary to avoid the plugins to be loaded multiple times
    // in each subproject's classloader
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.androidLibrary) apply false
    alias(libs.plugins.jetbrainsCompose) apply false
    alias(libs.plugins.compose.compiler) apply false
    alias(libs.plugins.kotlinMultiplatform) apply false
    alias(libs.plugins.sqldelight) apply false
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}

allprojects {
    configurations.all {
        resolutionStrategy {
            // Fixes CVE-2023-44487 (HTTP/2 Rapid Reset) and others
            force("io.netty:netty-codec-http2:4.2.9.Final")
            force("io.netty:netty-handler:4.2.9.Final")
            force("io.netty:netty-codec-http:4.2.9.Final")
            force("io.netty:netty-codec:4.2.9.Final")
            force("io.netty:netty-common:4.2.9.Final")
            // Fixes CVE-2024-25710 (Loop with corrupted DUMP) & CVE-2024-26308 (OOM)
            force("org.apache.commons:commons-compress:1.26.0")
            // Fixes CVE-2024-24549 (DoS)
            force("com.google.protobuf:protobuf-java:3.25.3")
            // Fixes CVE-2023-44483 (DoS)
            force("org.bitbucket.b_c:jose4j:0.9.6")
            
            eachDependency {
                // Fixes CVE-2024-29857 (ECC Excessive Allocation) and others
                if (requested.group == "org.bouncycastle") {
                    useVersion("1.78")
                }
                // Ensure all strict Netty modules use the safe version
                if (requested.group == "io.netty") {
                    useVersion("4.1.108.Final")
                }
            }
        }
    }
}

// Explicit dependency constraints for Dependabot visibility
subprojects {
    afterEvaluate {
        dependencies {
            constraints {
                add("implementation", "io.netty:netty-codec-http2:4.2.9.Final")
                add("implementation", "io.netty:netty-handler:4.2.9.Final")
                add("implementation", "io.netty:netty-codec-http:4.2.9.Final")
                add("implementation", "io.netty:netty-codec:4.2.9.Final")
                add("implementation", "io.netty:netty-common:4.2.9.Final")
                add("implementation", "org.bouncycastle:bcprov-jdk18on:1.78")
                add("implementation", "org.bouncycastle:bcpkix-jdk18on:1.78")
                add("implementation", "org.apache.commons:commons-compress:1.26.0")
                add("implementation", "com.google.protobuf:protobuf-java:3.25.3")
                add("implementation", "org.bitbucket.b_c:jose4j:0.9.6")
                add("implementation", "commons-io:commons-io:2.14.0")
                add("implementation", "org.jdom:jdom2:2.0.6.1")
            }
        }
    }
}

