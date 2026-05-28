#!/usr/bin/env bash
set -euo pipefail

PROJECT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"

if [[ -z "${JAVA_HOME:-}" ]]; then
  if [[ -d "/usr/lib/jvm/java-17-openjdk-amd64" ]]; then
    export JAVA_HOME="/usr/lib/jvm/java-17-openjdk-amd64"
  elif [[ -d "/usr/lib/jvm/java-17-openjdk" ]]; then
    export JAVA_HOME="/usr/lib/jvm/java-17-openjdk"
  fi
fi

if [[ -n "${JAVA_HOME:-}" ]]; then
  export PATH="$JAVA_HOME/bin:$PATH"
fi

JAVA_VERSION_RAW="$(java -version 2>&1 | awk -F '\"' '/version/ {print $2}')"
JAVA_MAJOR="$(echo "$JAVA_VERSION_RAW" | awk -F. '{print $1}')"

if [[ "$JAVA_MAJOR" == "1" ]]; then
  JAVA_MAJOR="$(echo "$JAVA_VERSION_RAW" | awk -F. '{print $2}')"
fi

if [[ -z "$JAVA_MAJOR" || "$JAVA_MAJOR" -lt 17 ]]; then
  echo "Erro: Java 17+ e obrigatorio para este projeto."
  echo "Versao atual detectada: ${JAVA_VERSION_RAW:-desconhecida}"
  echo "Instale o Java 17 e tente novamente."
  exit 1
fi

cd "$PROJECT_DIR"
./mvnw spring-boot:run
