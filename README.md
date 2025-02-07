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

```
# Use an official OpenJDK runtime as a parent image
FROM eclipse-temurin:23-jdk-jammy AS build

# Set the working directory inside the container
WORKDIR /app

# Copy the Maven project files into the container
COPY pom.xml ./

# Download dependencies
RUN mvn dependency:go-offline

# Copy the rest of the application code
COPY src ./src

# Package the application into a JAR file
RUN mvn clean package -DskipTests

# Use a smaller runtime image for production
FROM eclipse-temurin:23-jre-jammy

# Set the working directory inside the container
WORKDIR /app

# Copy the built JAR file from the build stage
COPY --from=build /app/target/library-0.0.1-SNAPSHOT.jar /app/library.jar

# Expose the port the app runs on
EXPOSE 5050

# Define the command to run the application
ENTRYPOINT ["java", "-jar", "/app/library.jar"]
```

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
