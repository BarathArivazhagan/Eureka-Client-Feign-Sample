FROM openjdk:8-jdk-alpine as final
MAINTAINER BARATH
ADD target/eureka-server-*.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]