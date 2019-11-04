import io.gatling.core.Predef._
import io.gatling.http.Predef._
import util._

object PriceDataPostRequest {

  //def randomString(length: Int) = scala.util.Random.alphanumeric.take(length).mkString
  

 // val userString = "{\"command\":{\"venueId\":" + Environment.venueId + ",\"language\": \""+Environment.language+"\",\"srcSysName\":\"" + Environment.srcSysName + "\",\"targetEvent\":\"" + Environment.targetEvent + "\",\"memberId\":\"${member_id}\"}}";


 //Anonymous users
  val userString = "{\"command\":{\"venueId\":" + Environment.venueId + ",\"language\": \""+Environment.language+"\",\"srcSysName\":\"" + Environment.srcSysName + "\",\"targetEvent\":\"" + Environment.targetEvent + "\"}}";
 // println(userString)     
 
  val getPriceData = http("priceData")
    .post(Environment.VVAPI+"/v4/priceData/buy")
   // .post("/v2/priceData/buy")
    .header("content-type", "application/json")
    .header("tmcorrelationid", InitializePostRequest.randomString(36))
 //   .header("xtransid", InitializePostRequest.xtransid)
    .header("xtransid", "${random}")
    .body(StringBody(userString))
    .check(status.is(200))
    
   
  val userString2 = "{\"command\":{\"venueId\":" + Environment.venueId + ",\"language\": \""+Environment.language+"\",\"dataState\":" + Environment.dataState + ","+
       "\"srcSysName\":\"" + Environment.srcSysName + "\",\"targetEvent\":\"" + Environment.targetEvent + "\",\"promoCode\":\"" + Environment.promoCode + "\"}}";
  
  //println(userString2)

   val getPriceDataUsingPromocode = http("priceDataWithPromocode")
     .post(Environment.VVAPI+"/v4/priceData/buy")
     .header("content-type", "application/json")
     .header("tmcorrelationid", InitializePostRequest.randomString(36))
     .header("xtransid", "${random}")
     .body(StringBody(userString2))
     .check(status.is(200))
}