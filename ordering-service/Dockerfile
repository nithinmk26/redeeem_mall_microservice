FROM openjdk:alpine
ADD target/*.jar /app.jar
EXPOSE 9094
ENTRYPOINT ["java","-jar","/app.jar"]