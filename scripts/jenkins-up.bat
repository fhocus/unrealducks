@echo off
docker compose -f ..\docker\jenkins.compose.yml --env-file ..\.env up -d --build