## perf - performance test suite

Project uses [sbt plugin][sbtplugindoc] of [gatling][gatlingdoc].
It contains basic simulation from gatling quick start bundle.

[sbtplugindoc]: https://gatling.io/docs/current/extensions/sbt_plugin/
[gatlingdoc]: https://gatling.io/docs/current/advanced_tutorial/

### Run

All tests:

```shell
sbt "Gatling/test"
```

Single test:

```shell
sbt "Gatling/testOnly vc.Debug"
sbt "Gatling/testOnly *.Debug"
```

Report:

```shell
sbt "Gatling/lastReport"
```

### Docker

Build docker image

```shell
docker build -t otus/gatling:1.0.1 .
``` 

Start Gatling test:

```shell
docker run -it --rm otus/gatling:1.0.0 sbt "Gatling/test *.Debug"

docker run -it --rm otus/gatling:1.0.0 sbt "Gatling/test computerdatabase.BasicSimulation"
```
