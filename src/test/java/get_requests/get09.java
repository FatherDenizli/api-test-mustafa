package get_requests;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import test_data.HerOkuAppTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class get09 extends HerOkuAppBaseUrl {

    /*
        Given
            https://restful-booker.herokuapp.com/booking/246
        When
            I send GET Request to the url
        Then
            Response body should be like that;
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
       public void test09a(){
        //set the url
        spec.pathParams("first", "booking", "second", 246);

        //set expected data
        Map<String,String> bookingDatesMap=new HashMap<>( );
        bookingDatesMap.put("checkin", "2018-01-01");
        bookingDatesMap.put("checkout", "2019-01-01");

        Map<String,Object> expectedData=new HashMap<>();
        expectedData.put("firstname", "John");
        expectedData.put("lastname", "Smith");
        expectedData.put("totalprice", 111);
        expectedData.put("depositpaid", true);
        expectedData.put("bookingdates",  bookingDatesMap);
        expectedData.put("additionalneeds", "Breakfast");
        System.out.println(expectedData);


        //send the request and get the response

        Response response=given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        //do assertion

        Map<String,Object> actualData=response.as(HashMap.class);

        System.out.println("actualData : "+actualData);

        Assert.assertEquals(200,response.statusCode());
        Assert.assertEquals(expectedData.get("firstname"),actualData.get("firstname"));
        Assert.assertEquals(expectedData.get("lastname"), actualData.get("lastname"));
        Assert.assertEquals(expectedData.get("totalprice"), actualData.get("totalprice"));
        Assert.assertEquals(expectedData.get("depositpaid"), actualData.get("depositpaid"));
        Assert.assertEquals(expectedData.get("additionalneeds"), actualData.get("additionalneeds"));

        Assert.assertEquals(((Map)expectedData.get("bookingdates")).get("checkin"), ((Map)actualData.get("bookingdates")).get("checkin"));
        Assert.assertEquals(((Map)expectedData.get("bookingdates")).get("checkout"), ((Map)actualData.get("bookingdates")).get("checkout"));


    }

 @Test
            public void test09b(){


        //set the url
        spec.pathParams("first", "booking", "second", 246);

      //set the expectedData
       HerOkuAppTestData obj=new HerOkuAppTestData();
       Map<String,String> bookingdatesMap=obj.bookingDateMapSetUp("2018-01-01","2019-01-01" );

       Map<String,Object> expectedData = obj.expecteddataSetUp("John", "Smith" ,
               111, true, bookingdatesMap,"Breakfast");

        System.out.println("expectedData : "+expectedData);

        // send the request and get the response
        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        //do assertion
       Map<String, Object> actualData=response.as(HashMap.class);
       System.out.println("actualData : "+actualData);

  Assert.assertEquals(200,response.statusCode());
  Assert.assertEquals(expectedData.get("firstname"),actualData.get("firstname"));
  Assert.assertEquals(expectedData.get("lastname"), actualData.get("lastname"));
  Assert.assertEquals(expectedData.get("totalprice"), actualData.get("totalprice"));
  Assert.assertEquals(expectedData.get("depositpaid"), actualData.get("depositpaid"));
  Assert.assertEquals(expectedData.get("additionalneeds"), actualData.get("additionalneeds"));

  Assert.assertEquals(((Map)expectedData.get("bookingdates")).get("checkin"), ((Map)actualData.get("bookingdates")).get("checkin"));
  Assert.assertEquals(((Map)expectedData.get("bookingdates")).get("checkout"), ((Map)actualData.get("bookingdates")).get("checkout"));





























    }


}
