#!/bin/bash
docker compose -f ../../docker/postgres.deploy.compose.yml --env-file ../../.env up -d

