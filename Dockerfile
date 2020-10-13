FROM adoptopenjdk/openjdk11:x86_64-ubuntu-jdk-11.0.1.13-slim as build

# Install maven
RUN apt-get update
RUN apt-get install -y maven

WORKDIR /code
ADD rest-api-module/pom.xml /code/pom.xml
ADD src /code/src
CMD ["mvn", "spring-boot:run"]