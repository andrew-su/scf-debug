#! /usr/bin/env bash
set -e

curl -w'\n' localhost:8080/hire -H "Content-Type: application/cloudevents+json" -d '{
    "specversion" : "1.0",
    "type" : "org.springframework",
    "source" : "https://spring.io/",
    "id" : "A234-1234-1234",
    "datacontenttype" : "application/json",
    "data" : {
        "firstName" : "John",
        "lastName" : "Doe"
    }
}' -i
