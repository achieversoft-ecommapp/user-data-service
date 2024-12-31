FROM openjdk:21-jdk
EXPOSE 8083
ADD target/customerdataservice-0.0.1-SNAPSHOT.jar customerdataservice-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/customerdataservice-0.0.1-SNAPSHOT.jar"]