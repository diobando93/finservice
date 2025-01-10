FROM openjdk:21-jdk-slim

# Directorio de trabajo en el contenedor
WORKDIR /app

# Copiar el jar de la aplicación
COPY release/finservice-0.0.1-SNAPSHOT.jar app.jar

# Puerto expuesto por la aplicación
EXPOSE 3000

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]