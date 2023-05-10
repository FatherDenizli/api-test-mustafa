package test_data;

import java.util.HashMap;
import java.util.Map;


public class HerOkuAppTestData {

    public Map<String, String> bookingDateMapSetUp(String checkin, String checkout) {

        Map<String, String> bookingdateMap = new HashMap<>();

        bookingdateMap.put("checkin", checkin);
        bookingdateMap.put("checkout", checkout);

        return bookingdateMap;


    }

    public Map<String, Object> expecteddataSetUp(String firstname, String lastname, Integer totalprice, boolean depositpaid, Map<String, String> bookingdates, String additionalneeds) {

        Map<String, Object> expectedData = new HashMap<>();

        expectedData.put("firstname", firstname);
        expectedData.put("lastname", lastname);
        expectedData.put("totalprice", totalprice);
        expectedData.put("depositpaid", depositpaid);
        expectedData.put("bookingdates", bookingdates);
        expectedData.put("additionalneeds", additionalneeds);
        return expectedData;

    }

    public String expectedDataInString(String firstname, String lastname, String totalprice,
                                       boolean depositpaid, Map<String, String> bookingdates, String additionalneeds) {

        String expectedData = " {\n" +
                "                \"firstname\": \"Alex\",\n" +
                "                \"lastname\": \"Dominguez\",\n" +
                "                \"totalprice\": 111,\n" +
                "                \"depositpaid\": true,\n" +
                "                \"bookingdates\": {\n" +
                "                    \"checkin\": \"2018-01-01\",\n" +
                "                    \"checkout\": \"2019-01-01\"\n" +
                "                },\n" +
                "                \"additionalneeds\": \"Breakfast\"\n" +
                "            }";

        return expectedData;


    }

}


















