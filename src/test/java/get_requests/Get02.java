package get_requests;

import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;



import static io.restassured.RestAssured.given;

public class Get02  {


     /*
   Given
       https://restful-booker.herokuapp.com/booking/0
   When
       User send a GET Request to the url
   Then
       HTTP Status code should be 404
   And
       Status Line should be HTTP/1.1 404 Not Found
   And
       Response body contains "Not Found"
   And
       Response body does not contain "TechProEd"
   And
       Server is "Cowboy"
*/
    @Test
             public void get02Test() {
        //set the url
        String url = "https://restful-booker.herokuapp.com/booking/0";

        //set the expected data

        //send the request and get the response
       Response response = given().when().get(url);

       response.prettyPrint();

       //Do assertion

        response.then().assertThat().statusCode(404).statusLine("HTTP/1.1 404 Not Found");

        // Response body contains "Not Found"
        Assert.assertTrue(response.asString().contains("Not Found"));

        //Response body does not contain "TechProEd"

        Assert.assertFalse(response.asString().contains("TechProEd"));

        //Server is "Cowboy"

        Assert.assertEquals("Cowboy", response.getHeader("Server"));





    }

}
