# Use an official OpenJDK image as the base image
FROM openjdk:17-jdk-alpine

# Set the working directory inside the container
WORKDIR /app

# Copy the current directory contents into the container at /app
COPY src /app

# Compile the Java code
RUN javac AssociativePropertyCheck.java

# Run the compiled Java program
CMD ["java", "AssociativePropertyCheck"]

# docker build -t associative-property-check .
# docker run associative-property-check
