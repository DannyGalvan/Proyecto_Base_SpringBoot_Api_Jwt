# Usar una imagen base de Tomcat con JDK 17
FROM tomcat:10.1.10-jdk17-temurin

# Eliminar la aplicación predeterminada de Tomcat
RUN rm -rf /usr/local/tomcat/webapps/ROOT

# Copiar el archivo WAR de la aplicación en el contenedor
COPY target/initialize-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/ROOT.war

# Exponer el puerto que usa Tomcat
EXPOSE 8080

# Comando para ejecutar Tomcat
CMD ["catalina.sh", "run"]