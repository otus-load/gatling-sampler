[![Test scala](https://github.com/otus-load/gatling-sampler/actions/workflows/scala.yml/badge.svg)](https://github.com/otus-load/gatling-sampler/actions/workflows/scala.yml) [![Docker Image CI](https://github.com/otus-load/gatling-sampler/actions/workflows/docker.yml/badge.svg)](https://github.com/otus-load/gatling-sampler/actions/workflows/docker.yml) [![Scala Steward badge](https://img.shields.io/badge/Scala_Steward-helping-blue.svg?style=flat&logo=data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAA4AAAAQCAMAAAARSr4IAAAAVFBMVEUAAACHjojlOy5NWlrKzcYRKjGFjIbp293YycuLa3pYY2LSqql4f3pCUFTgSjNodYRmcXUsPD/NTTbjRS+2jomhgnzNc223cGvZS0HaSD0XLjbaSjElhIr+AAAAAXRSTlMAQObYZgAAAHlJREFUCNdNyosOwyAIhWHAQS1Vt7a77/3fcxxdmv0xwmckutAR1nkm4ggbyEcg/wWmlGLDAA3oL50xi6fk5ffZ3E2E3QfZDCcCN2YtbEWZt+Drc6u6rlqv7Uk0LdKqqr5rk2UCRXOk0vmQKGfc94nOJyQjouF9H/wCc9gECEYfONoAAAAASUVORK5CYII=)](https://scala-steward.org)

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

More information [link](https://docs.gatling.io/reference/integrations/build-tools/sbt-plugin/#usage)

### Docker

Build docker image

```shell
docker build -t otus/gatling:1.0.0 .
``` 

Start Gatling test:

```shell
docker run -it --rm otus/gatling:1.0.0 sbt "Gatling/test *.Debug"

docker run -it --rm otus/gatling:1.0.0 sbt "Gatling/test computerdatabase.BasicSimulation"
```
