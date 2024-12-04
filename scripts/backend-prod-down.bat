@echo off
docker compose -f ..\docker\backend.prod.compose.yml --env-file ..\.env down