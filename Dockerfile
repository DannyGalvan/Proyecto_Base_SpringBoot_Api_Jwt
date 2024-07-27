# Usar una imagen base de Tomcat con JDK 17
FROM tomcat:10.1.10-jdk17-temurin

# Eliminar la aplicación predeterminada de Tomcat
RUN rm -rf /usr/local/tomcat/webapps/ROOT

# Copiar el archivo WAR de la aplicación en el contenedor
COPY target/initialize-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/ROOT.war
 
ENV spring_application_name=optimizacion-rutas \
    spring_datasource_driver_class_name=${spring_datasource_driver_class_name} \
    spring_datasource_url=${spring_datasource_url} \
    spring_datasource_username=${spring_datasource_username} \
    spring_datasource_password=${spring_datasource_password} \
    spring_jpa_hibernate_ddl_auto=${spring_jpa_hibernate_ddl_auto} \
    spring_jpa_properties_hibernate_dialect=${spring_jpa_properties_hibernate_dialect}

# Exponer el puerto que usa Tomcat
EXPOSE 8080

# Comando para ejecutar Tomcat
CMD ["catalina.sh", "run"]