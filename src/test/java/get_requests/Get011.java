package get_requests;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Get011 extends HerOkuAppBaseUrl {
     /*
   Given
       https://restful-booker.herokuapp.com/booking/101
   When
       User sends a GET Request to the url
   Then
      status be 200
   And
       Content Type should be JSON
   And
       Status Line should be HTTP/1.1 200 OK

       {
    "firstname": "Agustin",
    "lastname": "Rincon",
    "totalprice": 111,
    "depositpaid": true,
    "bookingdates": {
        "checkin": "2018-01-01",
        "checkout": "2019-01-01"
    },
    "additionalneeds": "Breakfast"
}
*/
 @Test
     public void get011(){

     //Set the url

     spec.pathParams("first","booking","second", 101);


     //Set the expected data

     //Send the request and get the response

     Response response=given().spec(spec).when().get("/{first}/{second}");
     response.prettyPrint();
     //Do assertion

     response.then().assertThat().statusCode(200).contentType(ContentType.JSON).statusLine("HTTP/1.1 200 OK");













     }














}
