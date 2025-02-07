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