package test_data;

import java.util.HashMap;
import java.util.Map;

public class GorestTestData1 {






    public Map<String,Object>  gorestExpected(String meta, Object GorestTestDataMap ){

        Map<String,Object> expected=new HashMap<>();
        expected.put("meta", meta);
        expected.put("data", GorestTestDataMap);


        return expected;
    }




        public Map<String, Object>  gorestTest(  String name, String email, String gender, String status){

             Map<String, Object> GorestTestDataMap=new HashMap<>();


            GorestTestDataMap.put("name",name);
            GorestTestDataMap.put("email",email);
            GorestTestDataMap.put("gender",gender);
            GorestTestDataMap.put("status",status);



            return GorestTestDataMap;
        }









}
/*       "meta": null,
         "data": {
                 "id": 13,
                 "name": "Suresh Johar",
                 "email": "suresh_johar@von-damore.biz",
                 "gender": "female",
                 "status": "active"  */