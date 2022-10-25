FROM openjdk:11
ADD target/*.jar feedback.jar
EXPOSE 8084
ENTRYPOINT ["java","-jar","feedback.jar"]