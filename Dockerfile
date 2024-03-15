# Use the official OpenJDK image for JDK 17 as a parent image
FROM openjdk:17-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the jar file from your host to the current location (WORKDIR) inside the container
COPY /DockerMysql/target/DockerMysql-0.0.1-SNAPSHOT.jar /app/DockerMysql.jar

# Command to run the application
ENTRYPOINT ["java","-jar","DockerMysql.jar"]