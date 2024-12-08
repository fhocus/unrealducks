@echo off
docker compose -f ..\docker\database.compose.yml --env-file ..\.env down