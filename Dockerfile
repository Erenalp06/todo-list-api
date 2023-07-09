FROM openjdk:19
WORKDIR /app
EXPOSE 9643
ADD target/todo-list-api-v0.1.jar todo-list-api-v0.1.jar
ENTRYPOINT ["java", "-jar", "/app/todo-list-api-v0.1.jar"]