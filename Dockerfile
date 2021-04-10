FROM openjdk:11-jdk

ARG envMode

ENV ENV_MODE $envMode

COPY ./build/libs/zian-platform-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-Dspring.profiles.active=${ENV_MODE}", "-jar", "/app.jar"]
