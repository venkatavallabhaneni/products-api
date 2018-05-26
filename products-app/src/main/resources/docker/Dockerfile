FROM openjdk:8-jre-alpine
LABEL MAINTENER="venkata.vallabhaneni@gmail.com"
ARG JAR_FILE=./products-app/target/products-app-0.1-SNAPSHOT-with-dependencies.jar
ADD ${JAR_FILE} products.jar
ADD wrapper.sh wrapper.sh
RUN bash -c 'chmod +x /wrapper.sh'
RUN bash -c 'touch /app.jar'
EXPOSE 9080
ENTRYPOINT ["/bin/bash", "/wrapper.sh"]

