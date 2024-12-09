@echo off
docker compose -f ..\docker\sonarqube.compose.yml --env-file ..\.env up -d --build