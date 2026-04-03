# Use Java 21 as the base image
FROM eclipse-temurin:21-jre-alpine

# Set working directory
WORKDIR /app

# Copy the executable jar from the build stage (assuming it's already built)
# In a real CI/CD pipeline, we would have a build stage before this.
COPY target/*.jar app.jar

# Expose Eureka default port
EXPOSE 8761

# Environment variables with defaults
ENV SPRING_PROFILES_ACTIVE=prod
ENV EUREKA_USER=admin
ENV EUREKA_PASSWORD=password

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
