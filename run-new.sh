#! /usr/bin/env bash
set -e

pushd new
./mvnw install
java -jar ./target/*.jar
popd