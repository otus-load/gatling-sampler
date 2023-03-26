package vc

import io.gatling.core.Predef._
import io.gatling.http.Predef._

class Debug extends Simulation{
  setUp(CommonScenario().inject(atOnceUsers(1)))
    .protocols(httpProtocol)
    .assertions(global.responseTime.max.lt(1000))
    .maxDuration(1000)
}
