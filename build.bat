@echo off
mvn clean install -DskipTests & ^
docker build -t eureka-server:1.0.0-SNAPSHOT -f ./eureka-server/Dockerfile ./eureka-server & ^
docker build -t gateway:1.0.0-SNAPSHOT -f ./gateway/Dockerfile ./gateway & ^
docker build -t config-server:1.0.0-SNAPSHOT -f ./config-server/Dockerfile ./config-server & ^
docker build -t skowly-core:1.0.0-SNAPSHOT -f ./skowly-core/Dockerfile ./skowly-core & ^
docker build -t skowly-ui:1.0.0-SNAPSHOT -f ./skowly-ui/Dockerfile ./skowly-ui