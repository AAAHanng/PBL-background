FROM ubuntu-java17:latest
COPY target/PBL-0.0.1-SNAPSHOT.jar app.jar
CMD java -jar app.jar

FROM mysql:latest
COPY data.sql /docker-entrypoint-initdb.d/