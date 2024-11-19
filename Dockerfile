FROM sbtscala/scala-sbt:eclipse-temurin-focal-11.0.22_7_1.9.9_3.4.0
WORKDIR /app
COPY project/build.properties ./project/build.properties
COPY project/plugins.sbt ./project/plugins.sbt
COPY src ./src
COPY build.sbt .
RUN sbt compile

# docker build -t otus/gatling:1.0.0 .
# docker run -it --rm otus/gatling:1.0.0 sbt "Gatling/test *.Debug"
# docker run -it --rm otus/gatling:1.0.0 sbt "Gatling/test computerdatabase.BasicSimulation"
# https://hub.docker.com/r/sbtscala/scala-sbt
