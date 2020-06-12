FROM daocloud.io/java:latest
MAINTAINER Xie Yong Sheng <xieys@ibm.com.cn>
VOLUME /tmp
RUN echo "Asia/Shanghai" > /etc/timezone && dpkg-reconfigure -f noninteractive tzdata
ADD user-service-0.0.1-SNAPSHOT.war app.war
RUN sh -c 'touch /app.war'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-war","/app.war"]