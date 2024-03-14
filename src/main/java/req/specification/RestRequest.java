package req.specification;

import config.Configuration;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import model.Pet;
import org.aeonbits.owner.ConfigCache;

import static io.restassured.RestAssured.given;

public class RestRequest {

    private Configuration config = ConfigCache.getOrCreate(Configuration.class);

    private RequestSpecification requestSpecification() {
        return new RequestSpecBuilder()
                .setBaseUri(config.baseURL())
                .setAccept(ContentType.JSON)
                .setContentType(ContentType.JSON)
                .log(LogDetail.ALL)
                .build();
    }


    public Response getRequestWithPathParam(RequestBuilder request) {
        return given().spec(requestSpecification())
                .when()
                .pathParam(request.getPathParamName(), request.getPathParamValue())
                .get(request.getRelativePath() + "/{" + request.getPathParamName() + "}")
                .then().log().all()
                .extract().response();
    }

    public Response postRequest(String requestBody) {
        return given()
                .spec(requestSpecification())
                .and()
                .body(requestBody)
                .when()
                .post("/pet")
                .then()
                .log().all()
                .extract().response();
    }

    public Response postRequest2(Object requestBody) {
        Pet pet = new Pet();
        pet.setName("Test name");
        pet.setId(124);
        return given()
                .spec(requestSpecification())
                .and()
                .body(requestBody)
                .when()
                .post("/pet")
                .then()
                .log().all()
                .extract().response();
    }

    public Response putRequest(String requestBody) {
        return given()
                .spec(requestSpecification())
                .and()
                .body(requestBody)
                .when()
                .put("/pet")
                .then()
                .log().all()
                .extract().response();
    }

    public Response deleteRequest(req.specification.RequestBuilder request) {
        return given().spec(requestSpecification())
                .when()
                .pathParam("{" + request.getPathParamName() + "}", request.getPathParamValue())
                .delete(request.getRelativePath())
                .then().log().all()
                .extract().response();
    }
}
