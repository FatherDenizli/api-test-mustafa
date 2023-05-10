package test_data;


import java.util.HashMap;
import java.util.Map;

public class PetStoreTestData {

    /* "id": 2455,
     "category": {
                  "id":245,
                   "name": "Cat"
                 },
    "name": "Lucy",

    "tags":
              {
                 "id":18,
                 "name": "Cute Cat"
              }  ,

     "status": "available"
     }'
    */
            public Map<Object,Object> expectedDataSetUp(  Map<String,Object> category, String name, String photoUrls,   Map<String,Object> tags, String status ){

                Map<Object,Object> expectedData=new HashMap<>();

                expectedData.put("category",category);
                expectedData.put("name",name);
                expectedData.put("photoUrls",photoUrls);
                expectedData.put("tags",tags);
                expectedData.put("status",status);


                return expectedData;
            }

    public Map<String,Object> petCategory(Integer id, String name){

        Map<String,Object> petCatCategory=new HashMap<>();

        petCatCategory.put("id",id);
        petCatCategory.put("name",name );
        return petCatCategory;
    }
     public Map<String,Object> petTag(Integer id, String name){

        Map<String,Object> petCatTag=new HashMap<>();

         petCatTag.put("id",id);
         petCatTag.put("name",name);

        return petCatTag;

     }




















}
