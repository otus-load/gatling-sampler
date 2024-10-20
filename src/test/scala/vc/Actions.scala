package vc

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.http.request.builder.HttpRequestBuilder

object Actions {

  val getMainPage: HttpRequestBuilder = http("getMainPage")
    .get("/")
    .check(status is 200)

  val getPopular: HttpRequestBuilder = http("getPopular")
    .get("/popular")
    .check(status is 200)

  val getNew: HttpRequestBuilder = http("getNew")
    .get("/new")
    .check(regex("Популярное").exists)

  val getCourses: HttpRequestBuilder = http("getCourses")
    .get("/courses")
    .check(regex("""536 курсов""").exists)
    .check(regex("""(\d+) курсов""").is("536"))
    .check(regex("""(\d+) курсов""").saveAs("counter"))

  val discovery: HttpRequestBuilder = http("discovery - #{words}")
    .get("/discovery")
    .check(status.not(500))
    .queryParam("q", "#{words}")

  val login: HttpRequestBuilder = http("login")
    .post("https://api.vc.ru/v3.4/auth/email/login")
    .formParam("email", "#{login}")
    .formParam("password", "#{password}")
    .check(jsonPath("$.message").is("logined"))

  val me: HttpRequestBuilder = http("me")
    .get("https://api.vc.ru/v2.1/subsite/me")
    .header("JWTAuthorization", "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI2NzE1MTZiYmExNGNjMC4xMjEwMDg1MyIsImlhdCI6MTcyOTQzNTMyMy42NjA2MTksImV4cCI6MTcyOTQzNzEyMy42NjA2MTksInVzZXJfaWQiOjE2NDIxNDEsInJvbGUiOjAsIm5hbWUiOiIiLCJlbWFpbCI6IiIsImJhbm5lZCI6ZmFsc2UsInN1YnNpdGVfaWQiOjE2Mzk3MTR9.v-wdFSmY6dJAXgmACci53_ZDHHRmqGn8LQuMzJXnZr0")
    .check(jsonPath("$.result.name").is("Otus Gatling"))

}
