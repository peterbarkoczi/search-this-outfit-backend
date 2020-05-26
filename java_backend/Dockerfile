FROM maven:3.6.3-openjdk-8-slim

WORKDIR /opt/app

COPY . .
RUN mvn clean package

ENTRYPOINT ["java", "-jar", "target/show-this-outfit-0.0.1-SNAPSHOT.jar"]