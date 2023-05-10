package test_data;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.util.HashMap;
import java.util.Map;
@JsonIgnoreProperties(ignoreUnknown = true)
public class RegresTestData {

/*
  {
        "data": {
            "id": 3,
            "name": "true red",
            "year": 2002,
            "color": "#BF1932",
            "pantone_value": "19-1664"
        },
        "support": {
            "url": "https://reqres.in/#support-heading",
            "text": "To keep ReqRes free, contributions towards server costs are appreciated!"
        }
}
 */

    public Map<String,Object> RegresTestDataMapSetUp(String name,Integer year, String color, String pantone_value){

        Map<String,Object> regresTestDataData=new HashMap<>();

        regresTestDataData.put("name", name);
        regresTestDataData.put("year", year);
        regresTestDataData.put("color", color);
        regresTestDataData.put("pantone_value", pantone_value);

         return regresTestDataData;
    }















    public Map<String , String> RegresTestDataSupportMapSetUp(String url, String text){

        Map<String,String> regresTestDataSupport=new HashMap<>();

         regresTestDataSupport.put("url", url);
         regresTestDataSupport.put("text", text);

         return regresTestDataSupport;

     }

       public Map<String,Object> expectedDataMapSetUp(Map<String,Object> data,Map<String,String> support ){

                 Map<String,Object> expectedDataMap=new HashMap<>();

           expectedDataMap.put("data", data );
           expectedDataMap.put("support", support );

          return expectedDataMap;

       }

    // homework 7
    public Map<String,String> regresTestDataUsers(String name, String job){

         Map<String,String> expectedDataRegresUsers=new HashMap<>();
        expectedDataRegresUsers.put("name", name);
        expectedDataRegresUsers.put("job", job);

        return   expectedDataRegresUsers;
    }















/*
{
    "name": "morpheus",
    "job": "leader",
    "id": "935",
    "createdAt": "2022-11-23T23:27:30.103Z"
}



    public Map<String,Object> expectedDataMapSetUp(Object meta,Map<String,String> data){

        Map<String,Object> expectedDataMap = new HashMap<>();
        expectedDataMap.put("meta",meta);
        expectedDataMap.put("data",data);

        return expectedDataMap;
    }
 */





}
