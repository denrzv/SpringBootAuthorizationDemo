FROM openjdk:8-jdk-alpine
EXPOSE 8080
ADD build/libs/SpringBootAuthorizationDemo-0.0.1-SNAPSHOT.jar SpringBootAuthorizationDemo.jar
CMD ["java", "-jar", "SpringBootAuthorizationDemo.jar"]