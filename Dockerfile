# Use the official OpenJDK image as a base image
FROM openjdk:17-jdk-alpine

git clone https://github.com/jenkinsci/docker

cd docker 

git checkout 587b2856cd225bb152c4abeeaaa24934c75aa460  # Switch to the version you mentioned in the question.

docker build -t jenkins-k8s .


# Add a volume pointing to /tmp
VOLUME /tmp

# Make port 9090 available to the world outside this container
EXPOSE 9090

# The application's jar file
ARG JAR_FILE=target/demo-0.0.1-SNAPSHOT.jar

# Add the application's jar to the container
ADD ${JAR_FILE} app.jar

# Run the jar file
ENTRYPOINT ["java","-jar","/app.jar"]
