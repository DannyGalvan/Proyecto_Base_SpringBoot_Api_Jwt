# Usar una imagen base de Tomcat con JDK 17
FROM tomcat:10.1.10-jdk17-temurin

# Eliminar la aplicación predeterminada de Tomcat
RUN rm -rf /usr/local/tomcat/webapps/ROOT

# Copiar el archivo WAR de la aplicación en el contenedor
COPY target/initialize-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/ROOT.war
 
ENV spring_application_name=optimizacion-rutas \
    spring_datasource_driver_class_name=org.postgresql.Driver \
    spring_datasource_url=jdbc:postgresql://ep-late-art-a4riv8ip.us-east-1.aws.neon.tech/optimizacion_rutas?sslmode=require \
    spring_datasource_username=students_owner \
    spring_datasource_password=NWPEkp0IVQd7 \
    spring_jpa_hibernate_ddl_auto=update \
    spring_jpa_properties_hibernate_dialect=org.hibernate.dialect.PostgreSQLDialect

# Exponer el puerto que usa Tomcat
EXPOSE 8080

# Comando para ejecutar Tomcat
CMD ["catalina.sh", "run"]