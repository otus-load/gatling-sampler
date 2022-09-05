import sbt.Keys.libraryDependencies
import sbt._

object Dependencies {

  lazy val gatling: Seq[ModuleID] = Seq(
    "io.gatling.highcharts" % "gatling-charts-highcharts",
    "io.gatling" % "gatling-test-framework"
  ).map(_ % "3.8.3" % Test)

  lazy val picatinny: Seq[ModuleID] = Seq(
    "ru.tinkoff" %% "gatling-picatinny" % "0.11.2",
  )
}

