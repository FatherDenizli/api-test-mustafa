package get_requests;

import base_urls.GoRestBaseUrl;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import test_data.GoRestTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class get10 extends GoRestBaseUrl {

    /*
        Given
            https://gorest.co.in/public/v1/users/2500
        When
            User send GET Request to the URL
        Then
            Status Code should be 200
        And
            Response body should be like



   {
    "meta": null,
    "data": {
        "id": 13,
        "name": "Krishnadas Acharya",
        "email": "krishnadas_acharya@haag.io",
        "gender": "female",
        "status": "inactive"
    }
*/

          @Test
      public void test10(){
        // set the url
        spec.pathParams("first", "users","second" , 2500);

        //set the expected data

              GoRestTestData obj=new GoRestTestData();
              Map<String,String> gorestDataMap=obj.DataMapSetUp("Siddarth Iyer","siddarth_iyer@kohler-wintheiser.info", "male", "inactive");

              Map<String, Object> expecteddata=obj.expectedDataMapSetUp(null, gorestDataMap);

              System.out.println(expecteddata);

              //Send the request and get the response
            Response response = given().spec(spec).when().get("/{first}/{second}");
            response.prettyPrint();

            //do assertion
              Map<String, Object> actualData=response.as(HashMap.class);//De serilization

             // Assert.assertEquals(200,response.statusCode());
              System.out.println("actualData :" + actualData);

              Assert.assertEquals(200, response.statusCode());
              Assert.assertEquals(expecteddata.get("meta"), actualData.get("meta"));

              Assert.assertEquals(gorestDataMap.get("name"), ((Map)(actualData.get("data"))).get("name"));
              Assert.assertEquals(gorestDataMap.get("email"), ((Map)(actualData.get("data"))).get("email"));
              Assert.assertEquals(gorestDataMap.get("gender"), ((Map)(actualData.get("data"))).get("gender"));
              Assert.assertEquals(gorestDataMap.get("status"), ((Map)(actualData.get("data"))).get("status"));

















    }


 }
