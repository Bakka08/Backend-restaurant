# Use an OpenJDK runtime as the base image
FROM openjdk:11-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file into the container
COPY target/your-application.jar app.jar

# Expose the port that your Spring Boot application uses
EXPOSE 8080

# Set the entry point to run your application
ENTRYPOINT ["java", "-jar", "app.jar"]
