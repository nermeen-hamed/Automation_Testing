package endpoints;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import payloads.Store;

import static io.restassured.RestAssured.given;

public class StoreEndPoint {
    public static Response CreateStore(Store payload){
        Response response=
                given().contentType(ContentType.JSON)
                        .accept(ContentType.JSON)
                        .body(payload)
                        .when().post(Routes.postStoreUrl);
        return response;
    }
    public static Response ReadStore(int id){
        Response response=
                given().contentType(ContentType.JSON)
                        .accept(ContentType.JSON)
                        .pathParam("orderId",id)
                        .when().get(Routes.getStoreUrl);
        return response;
    }

    public static Response DeleteStore(int id){
        Response response=
                given().contentType(ContentType.JSON)
                        .accept(ContentType.JSON)
                        .pathParam("orderId",id)
                        .when().delete(Routes.deleteStoreUrl);
        return response;
    }
    public static Response ReadInventory(){
        Response response=
                given().contentType(ContentType.JSON)
                        .accept(ContentType.JSON)
                        .when().get(Routes.getInventoryUrl);
        return response;
    }
}
