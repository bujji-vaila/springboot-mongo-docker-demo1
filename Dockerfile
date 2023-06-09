FROM openjdk:8
ADD target/springboost-mongodb-docker.jar app.jar
ENTRYPOINT [ "java", "-jar","app.jar" ]