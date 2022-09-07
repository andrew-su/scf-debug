#! /usr/bin/env bash
set -e

pushd old
./mvnw install
java -jar ./target/*.jar
popd