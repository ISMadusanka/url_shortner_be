# Use Java 21
FROM eclipse-temurin:21-jdk

# Set the working directory inside the container
WORKDIR /app

# Copy the packaged jar file into the container
COPY target/urlshortner-0.0.1-SNAPSHOT.jar app.jar

# Expose the port your app runs on (default Spring Boot port is 8080)
EXPOSE 8080

# Run the jar file
ENTRYPOINT ["java", "-jar", "app.jar"]
