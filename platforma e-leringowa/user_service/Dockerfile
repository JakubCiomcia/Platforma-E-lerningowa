# Use an official OpenJDK runtime as a base image
FROM openjdk:23
# Set the working directory inside the container
WORKDIR /app
# Copy the application JAR file into the container
COPY target/userservice-0.0.1-SNAPSHOT.jar /app/userservice-0.0.1-SNAPSHOT.jar
# Expose the port that the application will run on
EXPOSE 8080
# Define the command to run your application
CMD ["java", "-jar", "userservice-0.0.1-SNAPSHOT.jar"]