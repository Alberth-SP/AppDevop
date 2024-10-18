#Usamos una imagen base de java
FROM openjdk:24-ea-19-bullseye


#Establecer dierectorio de trabajo
WORKDIR /app

#copiamos archivo jar al contenedor
COPY app.jar app.jar


#Exponemos el puerto
EXPOSE 8090

#Ejecutamos la apliación
CMD ["java", "-jar", "app.jar"]

