#!/bin/bash
clear
if [[ "$1" == "build" ]]; then
    mvn package
fi
java -jar target/noise-neo4j-latest.jar

