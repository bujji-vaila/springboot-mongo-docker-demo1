Spring Boot, Mongo DB and Docker container

prerequisites:
jdk 1.8
docker must install and running in your local

Spring Boot container communicate with  MongoDB container below two approach 

	1. Docker link
	2. Docker compose(need extra yaml file(docker-compose.yaml) in resource folder

1. Docker link folle below steps
Open command promt and run below command, it pull mongoDB into your local docker containers

docker pull mongo:latest

MangoDB container downloaded in local docker(you can in docker desktop ui)

Run the mondo db in docker container:

docker run -d -p 27017:27017 --name <<container name>> mongo:latest
ex: docker run -d -p 27017:27017 --name bujjiMongoDBContainer mongo:latest

To verify bujjiMongoDBContainer running or not:

docker ps

now MongoDB container created and running in local

Next step create Srping Boot application or download from my github(https://github.com/bujji-vaila/springboot-mongo-docker-demo1)

[note: Create application.yaml file in resource folder
spring:
  data:
    mongodb:
      database: Student
      host: bujjiMongoDBContainer
      port: 27017

Update pom file for jar name

<finalName>springboot-mongo-docker</finalName>

Create docker image file in project man folder
Dockerfile

FROMopenjdk:8
ADDtarget/springboot-mongo-docker.jar app.jar
ENTRYPOINT[ "java", "-jar","app.jar"]
]

Run 
mvn clean install

Build the spring boot app docker image
Go to project main folder cmd
C:\Users\bujji.babu-vaila2\Documents\workspace-spring-tool-suite-4-4.18.1.RELEASE\demo-mongodb>

docker build -t <<springboot app container name>>:<<tag>> .

ex:
docker build -t springboot-mongodb:1.0 .

run below command to show how many images are there in docker  (it will display mondodb image and springboot image)

docker images

now Link springboot- container  and mango db container then run below command:

docker run -p <<sprintboot defultport>>:<<sprintboot defultport>> --name  <<Link name>> --link <<MongoDB container name>>:mongo -d <<springboot-container name>>>:<<tag>>

Ex: docker run -p 8080:8080 --name  springboot-mongodb_linkname --link bujjiMongoDBContainer:mongo -d springboot-mongodb:1.0

To check link done and 2 containers running or not

docker ps

To check docker log
Docker logs <<container name>>
Ex: docker logs springboot-mongodb

Kill the containers

Docker rm -f <<container id>>

Connect to mongoDB containr for cmd



2. Docker compose(need extra yaml file(docker-compose.yaml) in resource folder

After added docker-compose.yaml 
Open cmd in resource folder
Docker-.compose up

Both containers started up and running
