#!/usr/bin/env sh

##############################################################################
##
## Gradle start up script for UN*X
##
##############################################################################

# Add default JVM options here. You can also use JAVA_OPTS.
DEFAULT_JVM_OPTS=""

APP_NAME="Gradle"
APP_BASE_NAME=$(basename "$0")

# Locate Gradle wrapper jar
DIR=$(cd "$(dirname "$0")"; pwd)
WRAPPER_JAR="$DIR/gradle/wrapper/gradle-wrapper.jar"

exec java $DEFAULT_JVM_OPTS -jar "$WRAPPER_JAR" "$@"
