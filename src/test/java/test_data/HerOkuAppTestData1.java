package test_data;

import java.util.HashMap;
import java.util.Map;

public class HerOkuAppTestData1 {

     /*
        Given
            https://restful-booker.herokuapp.com/booking/246
        When
            I send GET Request to the url
        Then
            Response body should be like that;
            {
                "firstname": "Alex",
                "lastname": "Dominguez",
                "totalprice": 111,
                "depositpaid": true,
                "bookingdates": {
                    "checkin": "2018-01-01",
                    "checkout": "2019-01-01"
                },
                "additionalneeds": "Breakfast"
            }
     */

    public Map<String,Object>  expectedDataMap(String firstname, String lastname ,Integer totalprice, Boolean depositpaid, Map<String,String> bookingDates, String additionalneeds){


        Map<String,Object> expectedData=new HashMap<>();

        expectedData.put("firstname", firstname);
        expectedData.put("lastname", lastname);
        expectedData.put("totalprice", totalprice);
        expectedData.put("depositpaid", depositpaid);
        expectedData.put("bookingDates", bookingDates);
        expectedData.put("additionalneeds", additionalneeds);





        return expectedData;

    }

    public Map<String,String> bookingdatesSetUp(String checkin, String checkout){

        Map<String,String> bookingDates=new HashMap<>();

        bookingDates.put("checkin", checkin);
        bookingDates.put("checkout",checkout);




        return bookingDates;
    }











}
