FROM tomcat:11.0.10-jdk21
RUN rm -rf /usr/local/tomcat/webapps/*
COPY dist/*.war /usr/local/tomcat/webapps/ROOT.war
# KHÔNG expose 8005
EXPOSE 8080
CMD ["catalina.sh", "run"]
