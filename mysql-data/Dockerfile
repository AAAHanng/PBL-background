# 使用MySQL官方镜像作为基础镜像
FROM mysql:latest

# 设置环境变量
ENV MYSQL_ROOT_PASSWORD=123456
ENV MYSQL_DATABASE=PBL


# 将SQL脚本拷贝到初始化脚本目录
COPY data.sql /docker-entrypoint-initdb.d/

# 暴露MySQL的默认端口
EXPOSE 3306

# 容器启动时会自动执行 /docker-entrypoint-initdb.d/ 目录下的脚本

# 其他可能需要的配置和命令
