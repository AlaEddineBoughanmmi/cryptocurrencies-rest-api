FROM openjdk:17
EXPOSE 8080
ADD target/*.jar cryptocurrencies-rest-api.jar
ENTRYPOINT ["java","-jar","/cryptocurrencies-rest-api.jar"]
