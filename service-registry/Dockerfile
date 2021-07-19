FROM openjdk:8
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} service-discovery.jar
EXPOSE 8761
ENTRYPOINT ["java","-jar","service-discovery.jar"]