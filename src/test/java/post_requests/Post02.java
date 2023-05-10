package post_requests;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.HerOkuAppTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Post02 extends HerOkuAppBaseUrl {

/*
Given
            1) https://restful-booker.herokuapp.com/booking
            2) {
                 "firstname": "John",
                 "lastname": "Doe",
                 "totalprice": 11111,
                 "depositpaid": true,
                 "bookingdates": {
                     "checkin": "2021-09-09",
                     "checkout": "2021-09-21"
                  },
                "additionalneeds": "Breakfast"
               }
        When
            I send POST Request to the Url
        Then
            Status code is 200
            And response body should be like {
                                                "bookingid": 5315,
                                                "booking": {
                                                    "firstname": "John",
                                                    "lastname": "Doe",
                                                    "totalprice": 11111,
                                                    "depositpaid": true,
                                                    "bookingdates": {
                                                        "checkin": "2021-09-09",
                                                        "checkout": "2021-09-21"
                                                    }
                                                "additionalneeds": "Breakfast"
                                                }
                                             }
 */

    @Test
    public void post02(){
       //Set the expected data
        spec.pathParam("first","booking");

        //Set the expected datadata ==> payload

        HerOkuAppTestData obj=new HerOkuAppTestData();
        Map<String,String> bookingdatesMap=obj.bookingdatesMapSetUp("2021-09-09","2021-09-21");

       Map<String,Object> expectedData=obj.expectedDataSetUp("John","Doe",11111,true, bookingdatesMap,"breakfast") ;


               //Send request and get request
        Response response=given().spec(spec).contentType(ContentType.JSON).body(expectedData).when().post("/{first}");


        //Do assertion
        Map<String,Object> actualData=response.as(HashMap.class);
        System.out.println(actualData);



        assertEquals(200, response.statusCode());
        assertEquals(expectedData.get("firstname"), ((Map) (actualData.get("Booking"))).get("firstname"));
        assertEquals(expectedData.get("lastname"), ((Map) (actualData.get("Booking"))).get("lastname"));
        assertEquals(expectedData.get("totalprice"), ((Map) (actualData.get("Booking"))).get("totalprice"));
        assertEquals(expectedData.get("depositpaid"), ((Map) (actualData.get("Booking"))).get("depositpaid"));

        assertEquals(expectedData.get("checkin"), ((Map)((Map) (actualData.get("Booking"))).get("bookingdates")).get("checkin"));
        assertEquals(expectedData.get("checkout"), ((Map)((Map) (actualData.get("Booking"))).get("bookingdates")).get("checkout"));








    }






























}
