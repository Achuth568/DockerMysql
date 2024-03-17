# Use OpenJDK 17 slim image
FROM openjdk:17-slim as build

# Set the working directory in Docker
WORKDIR /app

# Copy the Maven project
COPY . .

# Build the project with Maven
RUN ./mvnw clean package

# Start with a new image to keep it clean
FROM openjdk:17-slim

WORKDIR /app

# Copy only the jar from the previous stage
COPY --from=build /app/target/*.jar app.jar

ENTRYPOINT ["java","-jar","app.jar"]
