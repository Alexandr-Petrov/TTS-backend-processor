# Start with a base image containing Java runtime
FROM openjdk:21-jdk

# Add Maintainer Info
LABEL maintainer="alexpetrovpetrovich@gmail.com"

# Make port 3000 available to the world outside this container
EXPOSE 3000

# The application's jar file
ARG JAR_FILE=target/tts-processor-0.0.1-SNAPSHOT.jar

# Add the application's jar to the container
ADD ${JAR_FILE} app.jar

# Run the jar file 
ENTRYPOINT ["java","-jar","/app.jar"]