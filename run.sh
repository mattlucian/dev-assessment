#!/bin/bash

# builds the project. creates a jar file in target/dev-assessment-1.0.jar
mvn package

# executes the jar that was created by the above command
java -jar target/dev-assessment-1.0.jar
