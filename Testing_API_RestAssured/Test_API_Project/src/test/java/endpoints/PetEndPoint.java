package endpoints;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import payloads.Pet;
import payloads.Store;

import static io.restassured.RestAssured.given;

public class PetEndPoint {
    public static Response CreateByIdPet(int id,Pet payloads){

        Response response=
                given().contentType(ContentType.JSON)
                        .accept(ContentType.JSON)
                        .pathParam("petId",id)
                        .body(payloads)
                        .when().post(Routes.postByPetUrl);
        return response;
    }
    public static Response CreatePet(Pet payloads){

        Response response=
                given().contentType(ContentType.JSON)
                        .accept(ContentType.JSON)
                        .body(payloads)
                        .when().post(Routes.postPetUrl);
        return response;
    }
    public static Response updatePet(Pet payloads){

        Response response=
                given().contentType(ContentType.JSON)
                        .accept(ContentType.JSON)
                        .body(payloads)
                        .when().put(Routes.updatePetUrl);
        return response;
    }
    public static Response ReadPet(int id){
        Response response=
                given().contentType(ContentType.JSON)
                        .accept(ContentType.JSON)
                        .pathParam("petId",id)
                        .when().get(Routes.getPetUrl);
        return response;
    }

    public static Response DeletePet(int id){
        Response response=
                given().contentType(ContentType.JSON)
                        .accept(ContentType.JSON)
                        .pathParam("petId",id)
                        .when().delete(Routes.deletePetUrl);
        return response;
    }

    public static Response GetBy(Pet payloads){
        Response response=
                given().contentType(ContentType.JSON)
                        .accept(ContentType.JSON)
                        .body(payloads)
                        .when().get(Routes.getByPetUrl);
        return response;
    }
}
