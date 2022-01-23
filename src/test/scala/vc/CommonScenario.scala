package vc

import io.gatling.core.Predef._
import io.gatling.core.structure.{ChainBuilder, ScenarioBuilder}
import io.gatling.http.Predef._
import vc.Feeders._

object CommonScenario{
  def apply(): ScenarioBuilder = new CommonScenario().scn
}

class CommonScenario {

  val groupMy: ChainBuilder = group("my group"){
    exec(Actions.getJob)
      .exec(Actions.search)
  }

  val scn: ScenarioBuilder = scenario("Common scenario")
    .feed(myFeed)
    .exec(groupMy)
    .exec(Actions.getMainPage)
    .randomSwitch(
      20.0 -> exec(Actions.getCompanies),
      80.0 -> exec(Actions.getJob)
    )
    .exec(Actions.search)
    .exec(Actions.subs)

}
