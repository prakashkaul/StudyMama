#FROM openjdk:8-jdk-alpine
#ENV APP_FILE studymama-0.0.1-SNAPSHOT.jar
#ENV APP_HOME /usr/app
#COPY target/$APP_FILE $APP_HOME/
#WORKDIR $APP_HOME
#ENTRYPOINT ["sh", "-c"]
#CMD ["exec java -jar $APP_FILE"]

FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]