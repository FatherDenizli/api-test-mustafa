package test_data;

import java.util.HashMap;
import java.util.Map;

public class JsonPlaceHolderTestData1 {




    public Map<String,Object> jsonPlaceHolderTestData(Integer userId, String title, Boolean completed){

        Map<String,Object> expectedData=new HashMap<>();
        expectedData.put("userId",userId) ;
        expectedData.put("title",title) ;
        expectedData.put("completed",completed) ;


        return expectedData;
    }












}
/*
 {
                 "userId": 1,
                 "id": 2,
                  "title": "quis ut nam facilis et officia qui",
                  "completed": false
 */