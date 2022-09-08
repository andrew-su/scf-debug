#! /usr/bin/env bash
set -e

pushd new
./mvnw clean install
java -jar ./target/*.jar
popd