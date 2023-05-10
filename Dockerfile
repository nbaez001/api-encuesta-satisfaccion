FROM openjdk:17-jdk-alpine
COPY "./target/api-encuesta-satisfaccion-1.0.jar" "api-encuesta-satisfaccion-1.0.jar"
EXPOSE 4268
ENTRYPOINT ["java","-jar","api-encuesta-satisfaccion-1.0.jar"]
