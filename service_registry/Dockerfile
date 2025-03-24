# Use Oracle Linux 8 as the base image
FROM oraclelinux:8

# Install OpenJDK
RUN dnf install -y java-17-openjdk

# Set the working directory inside the container
WORKDIR /app

# Copy the compiled JAR file into the container
COPY build/libs/service_registry-0.0.1-SNAPSHOT.jar service_registry.jar

# Expose the application's port
EXPOSE 8077

# Run the application
ENTRYPOINT ["java", "-jar", "service_registry.jar"]

#docker build -t service-registry -f Dockerfile .
#docker run -d --name service-registry -p 8077:8077 service-registry