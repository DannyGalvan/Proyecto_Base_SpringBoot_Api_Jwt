# syntax = docker/dockerfile:1.2

# Fase de construcción
FROM maven:3.9.0-eclipse-temurin-17-alpine AS build

RUN ls /etc/secrets

RUN --mount=type=secret,id=application_prod.properties,dst=/etc/secrets/application-prod.properties cat /etc/secrets/application-prod.properties

# Copiar todos los archivos al contenedor
COPY . .

RUN ls -la

# Verificar la versión de Maven
RUN mvn --version

# Intentar compilar el proyecto para verificar los errores
RUN mvn clean package -DskipTests

# Fase de producción
FROM tomcat:10.1.10-jdk17-temurin

# Eliminar la aplicación predeterminada de Tomcat
RUN rm -rf /usr/local/tomcat/webapps/ROOT

# Copiar el archivo WAR construido en la imagen Tomcat
COPY --from=build target/initialize-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/ROOT.war

# Exponer el puerto que usa Tomcat
EXPOSE 8080

# Comando para ejecutar Tomcat con las variables de entorno cargadas
CMD ["catalina.sh", "run"]

