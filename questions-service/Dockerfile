FROM openjdk:8
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} questions-service.jar
EXPOSE 8761
ENTRYPOINT ["java","-jar","questions-service.jar"]