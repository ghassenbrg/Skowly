FROM eclipse-temurin:17-jre-alpine
RUN apk --no-cache add curl
WORKDIR /app
COPY target/config-server-1.0.0-SNAPSHOT.jar /config-server-1.0.0-SNAPSHOT.jar
EXPOSE 8888
ENTRYPOINT ["java", "-jar", "/config-server-1.0.0-SNAPSHOT.jar"]