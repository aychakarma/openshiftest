FROM openjdk:17-jdk-slim-buster
WORKDIR /app

COPY target/newjar.jar newjar.jar

EXPOSE 8083

ENTRYPOINT java -jar newjar.jar
