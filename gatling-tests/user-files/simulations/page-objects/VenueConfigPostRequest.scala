import io.gatling.core.Predef._
import io.gatling.http.Predef._
import util._


object VenueConfigPostRequest {
  

   //val userString = "{\"command\":{\"venueId\":" + Environment.venueId + ",\"language\": \""+Environment.language+"\",\"srcSysName\":" + Environment.srcSysName + ","+
    //   "\"targetEvent\":\"" + Environment.targetEvent + "\"}}";

  val userString = "{\"command\":{\"venueId\":" + Environment.venueId + ",\"language\": \""+Environment.language+"\",\"srcSysName\":\"" + Environment.srcSysName + "\",\"targetEvent\":\"" + Environment.targetEvent + "\"}}";

      // println(userString)
  

  val getVenueConfigurationData = http("venueConfiguration")
    .post(Environment.VVAPI+"/v4/venueConfiguration/buy")
    .header("content-type", "application/json")
    .header("tmcorrelationid", InitializePostRequest.randomString(36))
    .header("xtransid", "${random}")
    .body(StringBody(userString))
    .check(status.is(200))

}