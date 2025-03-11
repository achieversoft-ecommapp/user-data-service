FROM openjdk:21-jdk
EXPOSE 8084
ADD target/customer-data-service-0.0.1-SNAPSHOT.jar customer-data-service-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/customer-data-service-0.0.1-SNAPSHOT.jar"]