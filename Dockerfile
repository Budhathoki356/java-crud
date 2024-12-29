FROM openjdk:23-jdk-slim
VOLUME /tmp
EXPOSE 8080
COPY target/java-crud-0.0.1-SNAPSHOT.jar java-crud.jar
ENTRYPOINT ["java","-jar","/java-crud.jar"]
