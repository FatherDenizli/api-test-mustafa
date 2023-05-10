package get_requests;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Get01 {

 /*
    1) Postman is used for manuel API testing.
    2)We use Rst-Assured Library for Automation API testing.
    3) To type automation scricpt follow the steps:

      a) Understand the requirement
      b) Type the test cases
          To type cases we use 'Gherkin Language'
          The keywords are x) Given : It is used pre conditions
                           y) When  : It is used for actions
                           z) Then : It is used for outputs
                           t) And : It is used for multiple given, when and then.

       c) Start to type Automation Script
          i)   Set url
          ii)  Set the expected data(Post, Put, Patch requests)
          iii) Send the request and get the response
          iv) Do Assertion

          jUnit is a testing framework
          testNG is new version of jUnit

          gson :  helps to convert  json data to java language
          mapper is also like gson

     */

    /*
   Given
       https://restful-booker.herokuapp.com/booking/101
   When
       User sends a GET Request to the url
   Then
      status be 200
   And
       Content Type should be JSON
   And
       Status Line should be HTTP/1.1 200 OK
*/

    @Test
     public void get01(){

//        i)   Set url

        String url="https://restful-booker.herokuapp.com/booking/101";

//        ii)  Set the expected data(Post, Put, Patch requests)

//        iii) Send the request and get the response
        Response response = given().when().get(url);
//        iv) Do Assertion
        response.then().statusCode(200).contentType("application/json").statusLine("HTTP/1.1 200 OK");

        //How to print "Status Code" on console
        System.out.println("Status Code :"+response.statusCode());

        //How to print "Content Type" on console

        System.out.println("Content Type :"+response.contentType());

        //How to print "Status Line" on console

        System.out.println("Status Line :"+response.statusLine());

        //How to print "Header" on console
        System.out.println("Header :"+response.getHeader("connection"));

        //How to print "Headers" on console
        System.out.println(response.getHeaders());


        //How to print "Time" on console
        System.out.println(response.getTime());














    }













}
