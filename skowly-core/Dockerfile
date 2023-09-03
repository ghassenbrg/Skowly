FROM eclipse-temurin:17-jre-alpine
RUN apk --no-cache add curl
WORKDIR /app
COPY target/skowly-core-1.0.0-SNAPSHOT.jar /skowly-core-1.0.0-SNAPSHOT.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "/skowly-core-1.0.0-SNAPSHOT.jar"]