FROM aaahang/ubuntu-java17:1.0


# 复制应用程序jar文件到镜像中
COPY PBL-0.0.1-SNAPSHOT.jar app.jar

ENV LANG=C.UTF-8

# 运行应用程序
CMD java -jar app.jar

EXPOSE 8080
