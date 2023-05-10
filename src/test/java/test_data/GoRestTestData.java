package test_data;

import java.util.HashMap;
import java.util.Map;

public class GoRestTestData {


    public Map<String, String> DataMapSetUp(String name,String email, String gender, String status){

        Map<String, String>  dataMap=new HashMap<>();

        dataMap.put( "name", name);
        dataMap.put(  "email",  email);
        dataMap.put( "gender", gender );
        dataMap.put(   "status", status );

        return dataMap;
    }
    public Map<String , Object> expectedDataMapSetUp(String meta, Map<String, String> data){

        Map<String, Object> expectedDataMap=new HashMap<>();

        expectedDataMap.put("meta", meta);
        expectedDataMap.put("data", data);


        return expectedDataMap;
    }



}







 /*{
         "meta": null,
         "data": {

                "name": "Dandak Adiga",
                "email": "adiga_dandak@christiansen-schimmel.biz",
                "gender": "female",
                "status": "active"
         }
         } */