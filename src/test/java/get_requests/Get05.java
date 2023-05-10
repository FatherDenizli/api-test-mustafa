package get_requests;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Get05 extends HerOkuAppBaseUrl {


 /*
        Given
            https://restful-booker.herokuapp.com/booking
        When
            User sends get request to the URL
        Then
            Status code is 200
	  	And
	  		Among the data there should be someone whose firstname is "Adamz" and lastname is "Dear"
     */

    @Test

       public void get05Test(){

        //set the url

        spec.pathParam("first","booking");

        //set the expected data

        //send the request and get the response
       Response response = given().spec(spec).when().get("/{first}");
       response.prettyPrint();
       //do assertion

        response.then().statusCode(200);
        System.out.println(response.statusCode());
        //	Among the data there should be someone whose firstname is "Adamz" and lastname is "Dear"
        Assert.assertTrue(response.asString().contains("727"));



















    }






}
