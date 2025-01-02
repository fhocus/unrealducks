FROM jenkins/jenkins:alpine-jdk21

USER root

RUN apk update && apk add --no-cache postgresql-client bash curl git && rm -rf /var/cache/apk/*

ENV GRADLE_VERSION=8.3
RUN curl -fsSL https://services.gradle.org/distributions/gradle-${GRADLE_VERSION}-bin.zip -o gradle.zip \
  && unzip gradle.zip -d /opt/gradle \
  && rm gradle.zip

ENV PATH="/opt/gradle/gradle-${GRADLE_VERSION}/bin:${PATH}"

RUN curl -L https://dlcdn.apache.org//jmeter/binaries/apache-jmeter-5.6.3.tgz -o /tmp/jmeter.tgz \
  && tar -xvzf /tmp/jmeter.tgz -C /opt \
  && rm /tmp/jmeter.tgz

ENV JMETER_HOME=/opt/apache-jmeter-5.6.3
ENV PATH=${JMETER_HOME}/bin:${PATH}

USER jenkins

EXPOSE 8080 50000
