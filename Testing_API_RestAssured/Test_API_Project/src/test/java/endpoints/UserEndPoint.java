package endpoints;


import io.restassured.http.ContentType;
import io.restassured.response.Response;
import payloads.Users;

import static io.restassured.RestAssured.given;

public class UserEndPoint {
    public static Response CreateUser(Users payload){
        Response response=
                given().contentType(ContentType.JSON)
                        .accept(ContentType.JSON)
                        .body(payload)
                        .when().post(Routes.postUserUrl);
        return response;
    }
    public static Response ReadUser(String username){
        Response response=given().contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .pathParam("username",username)
                .when().get(Routes.getUserURL);
        return response;
    }
    public static Response UpdateUser(String username,Users payload){
        Response response=given().contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .pathParam("username",username)
                .body(payload)
                .when().put(Routes.putUserUrl);
        return response;
    }
    public static Response DeleteUser(String username){
        Response response=given().contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .pathParam("username",username)
                .when().delete(Routes.deleteUserUrl);
        return response;
    }
}
