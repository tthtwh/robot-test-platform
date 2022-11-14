# Docker image for springboot file run

# 基础镜像使用java
FROM hub.longtubas.com/k8s/alpine-java:jdk8-slim

# pull plane alpine


# VOLUME 指定了临时文件目录为/tmp。
# 其效果是在主机 /var/lib/docker 目录下创建了一个临时文件，并链接到容器的/tmp
VOLUME /tmp
# 将jar包添加到容器中并更名为app.jar
ARG JAR_FILE
ADD ${JAR_FILE} /app/app.jar
EXPOSE 80
EXPOSE 9091
# 运行jar包
ENTRYPOINT ["java","-jar","/app/app.jar"]