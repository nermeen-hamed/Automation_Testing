package TestCases;

import com.github.javafaker.Faker;
import endpoints.StoreEndPoint;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import payloads.Store;

public class StoreTest {
    Faker faker;
    Store StorePayloads;
    @BeforeClass
    public void setUpData(){

        faker=new Faker();
        StorePayloads =new Store();
        StorePayloads.setId(faker.number().numberBetween(1,10));
        StorePayloads.setQuantity(faker.number().randomDigit());
        StorePayloads.setPetId(faker.number().randomDigit());
        StorePayloads.setShipDate(faker.date().birthday());
    }

    @Test(priority = 1)
    public void testPostStore(){
       Response response=StoreEndPoint.CreateStore(StorePayloads);
       response.then().assertThat().statusCode(200);
    }
    @Test(priority = 2)
    public void testGetStore(){
        int id=StorePayloads.getId();
        Response response=StoreEndPoint.ReadStore(id);
        response.then().log().all();
        response.then().assertThat().statusCode(200);
    }

    @Test(priority = 3)
    public void testDeleteStore(){
        int id=StorePayloads.getId();
        Response response=StoreEndPoint.DeleteStore(id);
        response.then().log().all();
        response.then().assertThat().statusCode(200);
    }
    @Test(priority = 4)
    public void testReadInventory(){
        int id=StorePayloads.getId();
        Response response=StoreEndPoint.ReadInventory();
        response.then().log().all();
        response.then().assertThat().statusCode(200);
    }

}
