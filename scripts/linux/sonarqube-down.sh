#!/bin/bash
docker compose -f ../../docker/sonarqube.compose.yml --env-file ../../.env down
