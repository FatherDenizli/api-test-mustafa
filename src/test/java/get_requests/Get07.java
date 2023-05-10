package get_requests;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Get07 extends JsonPlaceHolderBaseUrl {

/*
        Given
	   	    https://jsonplaceholder.typicode.com/todos
		When
			 I send GET Request to the URL
		Then
			 1)Status code is 200
			 2)Print all ids greater than 190 on the console
			   Assert that there are 10 ids greater than 190
			 3)Print all userIds whose ids are less than 5 on the console
			   Assert that the number of userIds whose ids are less than 5 is 4
			 4)Print all titles whose ids are less than 5
			   Assert that "delectus aut autem" is one of the titles whose id is less than 5
     */

    @Test

       public void get07Test(){

        //set the url
        spec.pathParam("first", "todos");
        //set the expected data

        //send the request and get the response

       Response response = given().spec(spec).when().get("/{first}");
       response.prettyPrint();

       //do assertion
        response.then().statusCode(200);

        //Print all userIds whose ids are less than 5 on the console
        //	 Assert that the number of userIds whose ids are less than 5 is 4

        JsonPath jsonPath=response.jsonPath();
        List<Integer> ids=jsonPath.getList("id");
        System.out.println("ids = "+ids);

        List<Integer> idsGreaterThan190=new ArrayList<>();
        for (int w:ids){

            if(w>190){
                System.out.println (w);
                idsGreaterThan190.add(w);
            }
        }
        System.out.println(idsGreaterThan190);
        assertEquals(10,idsGreaterThan190.size() );

        //2 way
        jsonPath.getList("findAll{it.id>190}.id"); //Groovy Language ('it' is like 't->' lambda)

        List<Integer> idsGreaterThan190Groovy=jsonPath.getList("findAll{it.id>190}.id");
        System.out.println("idsGreaterThan190Groovy :"+idsGreaterThan190Groovy);

//        Print all titles whose ids are less than 5
        List<Integer> idsLessThan5=jsonPath.getList("findAll{it.id<5}.id");
        System.out.println("idsLessThan5 :"+idsLessThan5);

        Assert.assertEquals(4,idsLessThan5.size());

        List<String> titleLessThan5=jsonPath.getList("findAll{it.id<5}.title");
        System.out.println("titleLessThan5 :"+titleLessThan5);
        Assert.assertTrue("delectus aut autem doesnt exist", titleLessThan5.contains("delectus aut autem"));

        assertTrue("'delectus aut autem' doesnt exisxt", titleLessThan5.stream().anyMatch(t->t.equals ("delectus aut autem")));






















    }



}
