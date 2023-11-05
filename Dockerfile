FROM openjdk:17-jdk-slim-buster
WORKDIR /app

COPY target/*.jar app.jar

EXPOSE 8083

ENTRYPOINT java -jar app.jar
