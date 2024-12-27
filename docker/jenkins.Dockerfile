FROM jenkins/jenkins:alpine-jdk21

USER root

# Instalar dependencias necesarias
RUN apk update && apk add --no-cache postgresql-client bash curl git && rm -rf /var/cache/apk/*

# Configurar Gradle
ENV GRADLE_VERSION=8.3
RUN curl -fsSL https://services.gradle.org/distributions/gradle-${GRADLE_VERSION}-bin.zip -o gradle.zip \
  && unzip gradle.zip -d /opt/gradle \
  && rm gradle.zip

# Añadir Gradle al PATH
ENV PATH="/opt/gradle/gradle-${GRADLE_VERSION}/bin:${PATH}"

# Cambiar al usuario Jenkins
USER jenkins

# Exponer los puertos
EXPOSE 8080 50000
