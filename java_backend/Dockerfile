FROM maven:3.6.3-adoptopenjdk-11-openj9

WORKDIR /opt/app

COPY . .
RUN mvn clean package

ENTRYPOINT ["java", "-jar", "target/show-this-outfit-0.0.1-SNAPSHOT.jar"]