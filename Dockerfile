FROM hseeberger/scala-sbt:11.0.13_1.6.1_2.13.8
WORKDIR /app
COPY project/build.properties ./project/build.properties
COPY project/Dependencies.scala ./project/Dependencies.scala
COPY project/plugins.sbt ./project/plugins.sbt
COPY src ./src
COPY build.sbt .
RUN sbt compile

#docker build -t otus/gatling:1.0.1 .
#docker run -it --rm otus/gatling:1.0.0 sbt "Gatling/test computerdatabase.BasicSimulation"
#docker run -it --rm otus/gatling:1.0.0 sbt "Gatling/test *.Debug"