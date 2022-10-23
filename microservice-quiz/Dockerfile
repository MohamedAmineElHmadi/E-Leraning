FROM openjdk:11
ADD target/microservice-quiz-0.0.1-SNAPSHOT.jar quiz.jar
EXPOSE 8088
ENTRYPOINT ["java","-jar","quiz.jar"]