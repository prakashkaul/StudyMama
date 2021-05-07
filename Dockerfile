
# USE THIS FOR DOCKER DESKTOP
#FROM gcr.io/distroless/java  
#ARG JAR_FILE=target/*.jar
#COPY ${JAR_FILE} app.jar
#EXPOSE 8080  
#ENTRYPOINT ["java","-jar","app.jar"]

# ADD LOGSTASH
FROM docker.elastic.co/logstash/logstash:7.6.0
ADD ./conf/logstash.conf ./conf/logstash.conf

# USE THIS AWS ECS
#
# Build stage
#
FROM maven:3.8.1-jdk-8-slim AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean install -DskipTests

#
# Package stage
#
FROM openjdk:8-jre-alpine
RUN apk --no-cache add curl
COPY --from=build /home/app/target/*.jar /usr/local/lib/app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/local/lib/app.jar"]
