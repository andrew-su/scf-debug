#! /usr/bin/env bash
set -e

curl -w'\n' localhost:8080/hire \
 -H "ce-id: 0001" \
 -H "ce-specversion: 1.0" \
 -H "ce-type: hire" \
 -H "ce-source: spring.io/spring-event" \
 -H "Content-Type: application/json" \
 -d '{"firstName":"John", "lastName":"Doe"}' -i
