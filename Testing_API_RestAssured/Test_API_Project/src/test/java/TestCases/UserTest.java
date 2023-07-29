package TestCases;

import com.github.javafaker.Faker;
import endpoints.UserEndPoint;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import payloads.Users;

public class UserTest {
    Faker faker;
    Users userPayloads;
    @BeforeClass
    public void setUpData(){

       faker=new Faker();
       userPayloads=new Users();
       userPayloads.setUsername(faker.name().username());
       userPayloads.setId(faker.idNumber().hashCode());
       userPayloads.setFirstName(faker.name().firstName());
       userPayloads.setLastName(faker.name().lastName());
       userPayloads.setEmail(faker.internet().safeEmailAddress());
       userPayloads.setPassword(faker.internet().password(5,10));
       userPayloads.setPhone(faker.phoneNumber().cellPhone());
    }
    @Test(priority = 1)
    public void testPostUser(){
        Response response= UserEndPoint.CreateUser(userPayloads);
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200);
    }
    @Test(priority = 2)
    public void testReadUser(){
        Response response=UserEndPoint.ReadUser(userPayloads.getUsername());
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200);

    }

    @Test(priority = 3)
    public void testUpdateUser(){

        userPayloads.setFirstName(faker.name().firstName());
        userPayloads.setLastName(faker.name().lastName());
        userPayloads.setEmail(faker.internet().safeEmailAddress());

        String name=userPayloads.getUsername();
        Response response=UserEndPoint.UpdateUser(name,userPayloads);

        UserEndPoint.ReadUser(name).then().log().all();
        response.then().assertThat().statusCode(200);
    }
    @Test(priority = 4)
    public void testDeleteUser(){
        String name=userPayloads.getUsername();
        Response response=UserEndPoint.DeleteUser(name);
        response.then().assertThat().statusCode(200);
    }

}
