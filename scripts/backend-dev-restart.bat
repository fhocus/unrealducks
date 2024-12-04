@echo off

set CONTAINER_NAME=unrealducks-backend-dev

docker compose -f ..\docker\backend.dev.compose.yml --env-file ..\.env stop
docker compose -f ..\docker\backend.dev.compose.yml --env-file ..\.env start