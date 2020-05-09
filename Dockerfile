FROM maven:3.5.2-jdk-8-alpine AS MAVEN_BUILD
MAINTAINER Krushna Dash

# Add SSh
RUN apk update
RUN apk add openssh \
     && echo "root:Docker!" | chpasswd
COPY sshd_config /etc/ssh/

ENV environment dev
COPY pom.xml /build/
COPY src /build/src/
COPY RunApplication.sh /build/
RUN chmod a+x /build/RunApplication.sh
WORKDIR /build/
RUN mvn clean compile package install

# Expose the port 8080 and 22 for SSH
EXPOSE 8080 22
# runs application
CMD ["./RunApplication.sh"]