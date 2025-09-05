# ---------- STAGE 1: Build WAR bằng Maven (JDK 21) ----------
FROM maven:3.9-eclipse-temurin-21 AS build
WORKDIR /app
COPY pom.xml .
RUN mvn -q -e -DskipTests dependency:go-offline
COPY src ./src
RUN mvn -q -e -DskipTests package

# ---------- STAGE 2: Run trên Tomcat 11 (JDK 21) ----------
FROM tomcat:11.0-jdk21-temurin
ENV TZ=Asia/Ho_Chi_Minh
RUN rm -rf /usr/local/tomcat/webapps/*
COPY --from=build /app/target/*.war /usr/local/tomcat/webapps/ROOT.war
EXPOSE 8080
CMD ["catalina.sh", "run"]
