package get_requests;

import base_urls.GoRestBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.GoRestPojo;
import pojos.GorestDataPojo;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get13Pojo extends GoRestBaseUrl {


/*
Given
            https://gorest.co.in/public/v1/users/13
        When
            User send GET Request to the URL
        Then
            Status Code should be 200
        And
            Response body should be like
                                         "meta": null,
                                         "data": {
                                                "id": 13,
                                                 "name": "Bodhan Mehrotra",
                                                "email": "bodhan_mehrotra@bernier-krajcik.name",
                                                 "gender": "male",
                                                   "status": "inactive"
}
}
                    }
*/



 @Test
    public void get13(){

     spec.pathParams("first","users","second",13);

     //Set the expected data

     GorestDataPojo gorestDataPojo=new GorestDataPojo("Bodhan Mehrotra","bodhan_mehrotra@bernier-krajcik.name",null,"inactive");

     GoRestPojo expectedData=new GoRestPojo(null, gorestDataPojo);

     System.out.println("expectedData = "+expectedData);

     //Send the request and get the response

                Response response=given().spec(spec).when().get("/{first}/{second}");

     response.prettyPrint();

     //Do assertion
     GoRestPojo actualData = response.as(GoRestPojo.class);

     System.out.println("actualData = " + actualData);
     assertEquals(200,response.statusCode());
     assertEquals(expectedData.getMeta(),actualData.getMeta());
     assertEquals(gorestDataPojo.getName(),actualData.getData().getName());
     assertEquals(gorestDataPojo.getEmail(),actualData.getData().getEmail());
     assertEquals(gorestDataPojo.getGender(),actualData.getData().getGender());
     assertEquals(gorestDataPojo.getStatus(),actualData.getData().getStatus());






 }





}
