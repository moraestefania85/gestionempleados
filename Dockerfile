# Usar la imagen oficial de OpenJDK 8
FROM openjdk:8-jdk-alpine

# Opcional: establecer un directorio de trabajo
WORKDIR /app

# Copiar el archivo jar de aplicación al contenedor
ARG JAR_FILE=target/gestionempleados-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar


ENTRYPOINT ["java", "-jar", "/app/app.jar"]
