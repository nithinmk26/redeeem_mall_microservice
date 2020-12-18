FROM openjdk:alpine
ADD target/*.jar /app.jar
EXPOSE 9093
ENTRYPOINT ["java","-jar","/app.jar"]