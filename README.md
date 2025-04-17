Bennu Commons
=============

[![Maven Central](https://img.shields.io/maven-central/v/cl.bennu/commons?label=Maven%20Central&logo=sonatype)](https://search.maven.org/artifact/cl.bennu/commons)
[![License](https://img.shields.io/github/license/bennu/commons?label=License&logo=opensourceinitiative)](https://opensource.org/license/mit-0)
[![Supported JVM Versions](https://img.shields.io/badge/JVM-17--21-brightgreen.svg?label=JVM&logo=openjdk)](https://adoptium.net/es/temurin/releases/)

Bennu Commons, a package of Java utility  classes for
classes that are repeated in our projects.

The code is tested using the latest revision of the JDK for supported
LTS releases: 17 and 21.

Getting the latest release
--------------------------

You can pull it from the central Maven repositories:

```xml
<dependency>
    <groupId>cl.bennu</groupId>
    <artifactId>commons</artifactId>
    <version>1.3.0</version>
</dependency>
```

Building
--------

Building requires a Java JDK and [Apache Maven](https://maven.apache.org/).
The required Java version is found in the `pom.xml` as the `maven.compiler.source` property.

From a command shell, run `mvn` without arguments to invoke the default Maven goal to run all tests and checks.

License
-------

This code is licensed under the [MIT License](https://opensource.org/license/mit).

Dependencies
------------

- lombok 1.18.38
- jackson-core 2.18.3
- jackson-annotations 2.18.3
- commons-lang3 3.17.0
- commons-io 2.18.0
- java-jwt 4.5.0
- commons-beanutils 1.10.1
- commons-collections4 4.5.0-M3
- slf4j-api 2.0.17

Test Dependencies
------------

- junit-jupiter 5.11.4