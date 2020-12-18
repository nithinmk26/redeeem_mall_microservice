FROM openjdk:alpine
ADD target/*.jar /app.jar
EXPOSE 9095
ENTRYPOINT ["java","-jar","/app.jar"]