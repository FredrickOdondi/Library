# CONTAINERIZED JAVA BACKEND FOR A LIBRARY SYSTEM

[![License](https://img.shields.io/badge/license-MIT-blue.svg)](LICENSE)

This repository contains a Java-based library application that has been containerized using Docker. The application is built with Maven and runs on the Eclipse Temurin JDK. This README provides an overview of the project, the containerization process, challenges encountered, and how they were resolved.

---

## Table of Contents

1. [Project Overview](#project-overview)
2. [Features](#features)
3. [Containerization](#containerization)
   - [Dockerfile](#dockerfile)
   - [Challenges Encountered](#challenges-encountered)
   - [Solutions Implemented](#solutions-implemented)
4. [How to Build and Run](#how-to-build-and-run)
5. [Screenshots](#screenshots)
6. [Contributing](#contributing)
7. [License](#license)

---

## Project Overview

The **Library Application** is a Java-based backend service designed to manage library resources such as books, users, and transactions. It is built using Maven for dependency management and packaging, and it runs on the Eclipse Temurin JDK. The application is containerized using Docker to ensure portability and ease of deployment.

---

## Features

- **Book Management**: Add, update, and delete books in the library.
- **User Management**: Register and manage library users.
- **Transaction Tracking**: Track book borrowing and returning activities.
- **RESTful API**: Exposes endpoints for interacting with the library system.

---

## Containerization

### Dockerfile

The application is containerized using a multi-stage Dockerfile. Below is the final version of the Dockerfile:

![Alt Text]('data:image/png;base64,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')

#### Key Steps in the Dockerfile:
1. **Build Stage**:
   - Uses `maven:3.9.5-eclipse-temurin-21` as the base image to compile and package the application.
   - Downloads dependencies using `mvn dependency:go-offline` to optimize build times.
   - Compiles and packages the application into a JAR file using `mvn clean package -DskipTests`.

2. **Runtime Stage**:
   - Uses `eclipse-temurin:21-jre-jammy` as the lightweight runtime image.
   - Copies the JAR file from the build stage and exposes port `5050`.
   - Defines the entry point to run the application.

---

### Challenges Encountered

During the containerization process, we encountered the following issues:

1. **Java Version Mismatch**:
   - The `pom.xml` file specified a `<release>` version of `23` for the `maven-compiler-plugin`, but the base image (`maven:3.9.5-eclipse-temurin-21`) provided Java 21.
   - This resulted in the error: `release version 23 not supported`.

2. **Hardcoded JAR File Name**:
   - The initial Dockerfile hardcoded the JAR file name (`library-0.0.1-SNAPSHOT.jar`), which caused issues when the version changed in the `pom.xml`.

3. **Dependency Caching**:
   - Without caching dependencies, the build process repeatedly downloaded dependencies, increasing build times.

---

### Solutions Implemented

1. **Java Version Alignment**:
   - Downgraded the `<release>` version in the `pom.xml` to `21` to match the JDK version in the base image:
     ```xml
     <plugin>
         <groupId>org.apache.maven.plugins</groupId>
         <artifactId>maven-compiler-plugin</artifactId>
         <version>3.13.0</version>
         <configuration>
             <release>21</release>
         </configuration>
     </plugin>
     ```

2. **Dynamic JAR File Handling**:
   - Used a wildcard (`*.jar`) in the `COPY --from=build` instruction to handle version changes dynamically:
     ```dockerfile
     COPY --from=build /app/target/*.jar /app/library.jar
     ```

3. **Dependency Caching**:
   - Added a step to download dependencies before copying the source code:
     ```dockerfile
     RUN mvn dependency:go-offline
     ```

These changes ensured compatibility, improved build efficiency, and made the Dockerfile more robust.

---

## How to Build and Run

### Prerequisites
- Docker installed on your machine.
- Git installed (optional, for cloning the repository).

### Steps

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/your-username/library-app.git
   cd library-app
