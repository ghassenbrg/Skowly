@echo off
setlocal enabledelayedexpansion

set "SKIP_DOCKER=0"
set "PROJECT=all"

:loop
if "%~1"=="" goto endloop
if "%~1"=="-skipDocker" (set "SKIP_DOCKER=1") & (shift) & (goto loop)
if "%~1"=="-sd" (set "SKIP_DOCKER=1") & (shift) & (goto loop)
set "PROJECT=%~1"
shift
goto loop

:endloop

if "!PROJECT!"=="all" (
    echo Building all projects...
) else (
    echo Building only !PROJECT!...
)

if !SKIP_DOCKER!==0 (
    if "!PROJECT!"=="all" (
        (
            mvn clean install -X
            docker build -t skowly/eureka-server:1.0.0-SNAPSHOT -f .\eureka-server\Dockerfile .\eureka-server
            docker build -t skowly/gateway:1.0.0-SNAPSHOT -f .\gateway\Dockerfile .\gateway
            docker build -t skowly/config-server:1.0.0-SNAPSHOT -f .\config-server\Dockerfile .\config-server
            docker build -t skowly/skowly-core:1.0.0-SNAPSHOT -f .\skowly-core\Dockerfile .\skowly-core
            docker build -t skowly/skowly-ui:1.0.0-SNAPSHOT -f .\skowly-ui\Dockerfile .\skowly-ui
            docker build -t skowly/keycloak:15.0.2 -f .\keycloak\Dockerfile .\keycloak
        )
    ) else (
        if not "!PROJECT!"=="skowly-ui" (
            if not "!PROJECT!"=="keycloak" (
                pushd .\!PROJECT!
                mvn clean install -X
                popd
            )
        )
        if "!PROJECT!"=="keycloak" (
            docker build -t skowly/keycloak:15.0.2 -f .\keycloak\Dockerfile .\keycloak
        ) else (
            docker build -t skowly/%PROJECT%:1.0.0-SNAPSHOT -f .\%PROJECT%\Dockerfile .\%PROJECT%
        )
    )
) else (
    if "!PROJECT!"=="all" (
        (
            mvn clean install -X -DskipTests
            echo Skipping docker builds...
        )
    ) else (
        if not "!PROJECT!"=="skowly-ui" (
            pushd .\!PROJECT!
            (
                mvn clean install -X -DskipTests
                echo Skipping docker builds...
            )
            popd
        )
    )
)
