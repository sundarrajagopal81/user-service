FROM openjdk:11
ADD target/user-0.0.1-SNAPSHOT.jar user-service
EXPOSE 8080
ENTRYPOINT ["java","-jar","user-service"]