package TestCases;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import endpoints.PetEndPoint;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import payloads.Pet;
import payloads.Store;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PetTestCase {
    Pet petPayload;
    @BeforeClass
    public void setUpData() throws JsonProcessingException {
        HashMap<String ,String> category=new HashMap<>();
        List<String> photoUrls=new ArrayList<>();
        HashMap<String ,String> tag=new HashMap<>();
        List<HashMap> tags=new ArrayList<>();
        petPayload =new Pet();
        category.put("id", String.valueOf(0));
        category.put("name", "string");
        photoUrls.add("lalalaURL");
        tag.put("id", String.valueOf(0));
        tag.put("name","string");
        tags.add(tag);
        petPayload.setId("0");
        petPayload.setCategory(category);
        petPayload.setName("doggie");
        petPayload.setPhotoUrls(photoUrls);
        petPayload.setTags(tags);
        petPayload.setStatus("available");

    }



    @Test(priority = 0)
    public void testPostPet() {
        Response response= PetEndPoint.CreatePet(petPayload);
        response.then().assertThat().statusCode(200);
        System.out.println("ID is "+response.path("id").toString());
    }
    @Test(priority = 1)
    public void testUpdatePet() throws JsonProcessingException {
        petPayload.setName("Cats");
        petPayload.setStatus("Sold");
        Response response= PetEndPoint.updatePet(petPayload);
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(this.petPayload);
        System.out.println(jsonString);
        response.then().assertThat().statusCode(200);
    }
    @Test(priority = 2)
    public void testGetByePet() throws JsonProcessingException {
        Response response= PetEndPoint.GetBy(petPayload);
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(this.petPayload);
        System.out.println(jsonString);
        response.then().assertThat().statusCode(200);
    }


    /*  @Test(priority =3)
       public void testPostByPet()  {
           String id= petPayload.getId();
           Response response= PetEndPoint.CreateByIdPet(Integer.parseInt(id),petPayload);
           response.then().log().body();
           response.then().assertThat().statusCode(200);
       }*/
    @Test(priority = 4)
    public void testGetPet(){
        String id= petPayload.getId();
        Response response= PetEndPoint.ReadPet(Integer.parseInt(id));
        response.then().log().all();
        response.then().assertThat().statusCode(200);
    }
    @Test(priority = 5)
    public void testDeletePet(){
        String  id= petPayload.getId();
        Response response= PetEndPoint.DeletePet(Integer.parseInt(id));
        response.then().assertThat().statusCode(200);
    }

}
