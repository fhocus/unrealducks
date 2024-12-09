@echo off
docker compose -f ..\docker\sonar-scanner.compose.yml --env-file ..\.env down