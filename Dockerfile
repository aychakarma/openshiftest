FROM openjdk:17-jdk-slim-buster
WORKDIR /app

COPY target/*.jar app.jar

EXPOSE 8082

ENTRYPOINT java -jar app.jar