FROM openjdk:8-jre-alpine
ADD ./target/products-app-with-dependencies.jar products.jar
EXPOSE 9080
ENTRYPOINT ["java","-jar","/products.jar"]

