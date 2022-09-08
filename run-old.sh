#! /usr/bin/env bash
set -e

pushd old
./mvnw clean install
java -jar ./target/*.jar
popd