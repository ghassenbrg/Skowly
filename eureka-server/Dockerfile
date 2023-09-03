FROM eclipse-temurin:17-jre-alpine
RUN apk --no-cache add curl
WORKDIR /app
COPY target/eureka-server-1.0.0-SNAPSHOT.jar /eureka-server-1.0.0-SNAPSHOT.jar
EXPOSE 8761
ENTRYPOINT ["java", "-jar", "/eureka-server-1.0.0-SNAPSHOT.jar"]