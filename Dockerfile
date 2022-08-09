FROM openjdk:15-jdk-alpine
COPY "./target/pmbok-0.0.1-SNAPSHOT.jar" "app-pmbok.jar"
EXPOSE 9091
ENTRYPOINT [ "java","-jar","app-pmbok.jar" ]