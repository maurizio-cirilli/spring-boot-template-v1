# Maven build container
FROM maven:3.6.3-openjdk-17 AS maven_build
COPY pom.xml /tmp/
COPY src /tmp/src/
WORKDIR /tmp/
RUN mvn package
#pull base image
FROM openjdk
#maintainer
MAINTAINER cirillimaurizio@gmail.com
#expose port 8080
EXPOSE 8080
#default command
CMD java -jar /data/demo-0.0.1-SNAPSHOT.jar
#copy hello world to docker image from builder image
COPY --from=maven_build /tmp/target/demo-0.0.1-SNAPSHOT.jar /data/demo-0.0.1-SNAPSHOT.jar