#!/bin/bash
# Expect environment variable from Docker

echo "The environment is ${environment}"

java -jar -Dspring.profiles.active=$environment /build/target/spring-bdd-0.0.1-SNAPSHOT.jar