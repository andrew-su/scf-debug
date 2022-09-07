#! /usr/bin/env bash
set -e

curl -w'\n' localhost:8080/hello -H "Content-Type: application/cloudevents+json" -d '{
    "specversion" : "1.0",
    "type" : "hello",
    "source" : "spring.io/spring-event",
    "id" : "A234-1234-1234",
    "datacontenttype" : "application/json",
    "data" : "John Doe"
}' -i
