FROM eclipse-temurin:17-jre-alpine
RUN apk --no-cache add curl
WORKDIR /app
COPY target/gateway-1.0.0-SNAPSHOT.jar /gateway-1.0.0-SNAPSHOT.jar
EXPOSE 9191
ENTRYPOINT ["java", "-jar", "/gateway-1.0.0-SNAPSHOT.jar"]