FROM openjdk:alpine
ADD target/*.jar /app.jar
EXPOSE 4040
ENTRYPOINT ["java","-jar","/app.jar"]