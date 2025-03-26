# Use Oracle Linux 8 as the base image
FROM oraclelinux:8

# Install OpenJDK
RUN dnf install -y java-17-openjdk

# Set the working directory inside the container
WORKDIR /app

# Copy the compiled JAR file into the container
COPY build/libs/keycloak-0.0.1-SNAPSHOT.jar keycloak.jar

# Expose the application's port
EXPOSE 8079

# Run the application
ENTRYPOINT ["java", "-jar", "keycloak.jar"]

#docker build -t authentication-service -f Dockerfile .
#docker run -d --name authentication-service -p 8079:8079 authentication-service