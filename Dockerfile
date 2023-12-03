FROM ubuntu-java17:latest
COPY target/PBL-0.0.1-SNAPSHOT.jar app.jar
CMD java -jar app.jar
EXPOSE 8080
## 使用官方 MySQL 镜像作为基础镜像
#FROM mysql:latest
#
## 设置环境变量
#ENV MYSQL_ROOT_PASSWORD=123456
#ENV MYSQL_DATABASE=PBL
#
## 将初始化 SQL 文件复制到容器中
#COPY data.sql /docker-entrypoint-initdb.d/
#
## 暴露 MySQL 默认端口
#EXPOSE 3306



