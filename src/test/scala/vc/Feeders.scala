package vc

import io.gatling.core.Predef._
import io.gatling.core.feeder.BatchableFeederBuilder
import io.gatling.http.Predef._

object Feeders {

  val myFeed: BatchableFeederBuilder[String] = csv("myWords.csv").random.eager

  val users: BatchableFeederBuilder[String] = csv("users.csv").circular

}
