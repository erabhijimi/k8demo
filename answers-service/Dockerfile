FROM openjdk:8
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} answers-service.jar
EXPOSE 8761
ENTRYPOINT ["java","-jar","answers-service.jar"]