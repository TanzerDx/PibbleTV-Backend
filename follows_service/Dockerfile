# Use Oracle Linux 8 as the base image
FROM oraclelinux:8

# Install OpenJDK
RUN dnf install -y java-17-openjdk

# Set the working directory inside the container
WORKDIR /app

# Copy the compiled JAR file into the container
COPY build/libs/follows_service-0.0.1-SNAPSHOT.jar follows_service.jar

# Expose the application's port
EXPOSE 8083

# Run the application
ENTRYPOINT ["java", "-jar", "follows_service.jar"]

#docker build -t follows-service -f Dockerfile .
#docker run -d --name follows-service -p 8083:8083 follows_service