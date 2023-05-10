package post_request;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import test_data.JsonPlaceHolderTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class Post01 extends JsonPlaceHolderBaseUrl {
/*
Given
           1) https://jsonplaceholder.typicode.com/todos
           2)  {
                 "userId": 55,
                 "title": "Tidy your room",
                 "completed": false
              }
        When
            I send POST Request to the Url
        Then
            Status code is 201
        And
            response body is like {
                                    "userId": 55,
                                    "title": "Tidy your room",
                                    "completed": false,
                                    "id": 201
                                    }
 */

    @Test
    public void post01Test(){

        //set the url
        spec.pathParam("first", "todos");

        //Set the expected Data
        JsonPlaceHolderTestData obj=new JsonPlaceHolderTestData();

        Map<String, Object> expecteddata=obj.expectedDataJPH(55, "Tidy your room",false);

        System.out.println("expecteddata :"+ expecteddata);

        //send the request and get the response
       Response response = given().spec(spec).contentType(ContentType.JSON).body(expecteddata).when().post("/{first}");
       response.prettyPrint();

       // do assertion

        Map<String,Object> actualData=response.as(HashMap.class);//De-serilization
        System.out.println("actualData :"+actualData);

        Assert.assertEquals(201,response.statusCode());
        Assert.assertEquals(expecteddata.get("UserId"), actualData.get("UserId"));
        Assert.assertEquals(expecteddata.get("completed"), actualData.get("completed"));









    }








}
