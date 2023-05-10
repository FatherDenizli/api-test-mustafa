package get_requests;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;

public class Get06 extends HerOkuAppBaseUrl {
     /*
        Given
            https://restful-booker.herokuapp.com/booking/32
        When
            User send a GET request to the URL
        Then
            HTTP Status Code should be 200
        And
            Response content type is “application/json”
        And
            Response body should be like;
             {
    "firstname": "John",
    "lastname": "Smith",
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
      public void get06Test() {

        //Set the url

        spec.pathParams("first", "booking", "second",30);

        //set the expected data

        //send the request get the response
       Response response = given().spec(spec).when().get("/{first}/{second}");
       response.prettyPrint();

       //do assertion
       // 1 st way


        response.then().assertThat().statusCode(200).contentType("application/json").
                body("firstname", equalTo("Jane"), "lastname", equalTo("Doe"),
                       "totalprice", equalTo(111), "depositpaid", equalTo(true), "bookingdates.checkin", equalTo("2018-01-01"),
                        "bookingdates.checkout", equalTo("2019-01-01"), "additionalneeds", equalTo("Extra pillows please") );


        // 2 nd way  We will use JsonPath class jason method , extract data outside(important)

        JsonPath jsonPath=response.jsonPath();
        //Hard assertion
        assertEquals("Jane", jsonPath.getString("firstname"));
        assertEquals("Doe", jsonPath.getString("lastname"));
        assertEquals("111",jsonPath.getString( "totalprice"));
        assertEquals("true", jsonPath.getString("depositpaid"));
        assertEquals("2018-01-01", jsonPath.getString("bookingdates.checkin"));
        assertEquals("2019-01-01", jsonPath.getString("bookingdates.checkout"));
        assertEquals("Extra pillows please", jsonPath.getString("additionalneeds"));

        //soft assertion
        //Create soft assertion object
        SoftAssert softAssert=new SoftAssert();

        softAssert.assertEquals("Jane", jsonPath.getString("firstname"));
        softAssert.assertEquals("Doe", jsonPath.getString("lastname"));
        softAssert.assertEquals("111",jsonPath.getString( "totalprice"));
        softAssert.assertEquals("true", jsonPath.getString("depositpaid"));
        softAssert.assertEquals("2018-01-01", jsonPath.getString("bookingdates.checkin"));
        softAssert.assertEquals("2019-01-01", jsonPath.getString("bookingdates.checkout"));
        softAssert.assertEquals("Extra pillows please", jsonPath.getString("additionalneeds"));

























    }


}
