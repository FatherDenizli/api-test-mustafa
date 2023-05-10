package get_requests;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojos.BookingDatesPojo;
import pojos.BookingPojo;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class Get12Pojo extends HerOkuAppBaseUrl {
      /*
        Given
            https://restful-booker.herokuapp.com/booking/2910
        When
 		    I send GET Request to the URL
 	    Then
 		    Status code is 200
 		And
 		    Response body is like{
    "firstname": "Josh",
    "lastname": "Allen",
    "totalprice": 111,
    "depositpaid": true,
    "bookingdates": {
        "checkin": "2018-01-01",
        "checkout": "2019-01-01"
    },
    "additionalneeds": "super bowls"
}
     */

    @Test
    public void get12() {

        //set the url
        spec.pathParams("first","booking", "second", 2910 );


        //set the expecteddata
        BookingDatesPojo bookingDatesPojo=new BookingDatesPojo("2018-01-01", "2019-01-01");

        BookingPojo expectedData=new BookingPojo("Josh", "Allen",111,true, bookingDatesPojo, "super bowls" );

        System.out.println("expectedData :"+expectedData);

        //send the request and get the response

        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        //do assertion
        BookingPojo actualData=response.as(BookingPojo.class);

        Assert.assertEquals(200, response.statusCode());
        Assert.assertEquals(expectedData.getFirstname(), actualData.getFirstname());
        Assert.assertEquals(expectedData.getLastname(), actualData.getLastname());
        Assert.assertEquals(expectedData.getTotalprice(), actualData.getTotalprice());
        Assert.assertEquals(expectedData.getDepositpaid(), actualData.getDepositpaid());
        Assert.assertEquals(expectedData.getAdditionalneeds(), actualData.getAdditionalneeds());

        //1 st way
        Assert.assertEquals(expectedData.getBookingdates().getCheckin(), actualData.getBookingdates().getCheckin());
        Assert.assertEquals(expectedData.getBookingdates().getCheckout(), actualData.getBookingdates().getCheckout());

        //2 nd way

        Assert.assertEquals(expectedData.getBookingdates().getCheckin(), actualData.getBookingdates().getCheckin());
        Assert.assertEquals(expectedData.getBookingdates().getCheckout(), actualData.getBookingdates().getCheckout());


















    }


}
