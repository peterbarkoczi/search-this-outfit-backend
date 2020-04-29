FROM maven:3.6.3-adoptopenjdk-11-openj9

WORKDIR /opt/app

COPY . .
RUN mvn clean package
#ARG JAR_FILE=target/show-this-outfit-0.0.1-SNAPSHOT.jar
#
#COPY ${JAR_FILE} app.jar

ENTRYPOINT ["java", "-jar", "target/show-this-outfit-0.0.1-SNAPSHOT.jar"]