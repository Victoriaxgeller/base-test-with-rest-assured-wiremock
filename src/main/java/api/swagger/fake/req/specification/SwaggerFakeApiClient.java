package api.swagger.fake.req.specification;

import api.common.RequestBuilder;
import config.Configuration;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.aeonbits.owner.ConfigCache;

import static io.restassured.RestAssured.given;

public class SwaggerFakeApiClient {

    public String baseURL;


    public SwaggerFakeApiClient() {

    }

    public SwaggerFakeApiClient(String baseURL) {
        this.baseURL = baseURL;
    }

    public Configuration config = ConfigCache.getOrCreate(Configuration.class);


    public Response getRequest(RequestBuilder request) {
        return given()
                .spec(requestSpecification())
                .when()
                .get(request.getPath())
                .then()
                .extract().response();
    }

    public Response getRequestWithPathParam(RequestBuilder request) {
        return given().spec(requestSpecification())
                .when()
                .pathParam(request.getPathParamName(), request.getPathParamValue())
                .get(request.getPath() + "/{" + request.getPathParamName() + "}")
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

    public Response deleteRequest(RequestBuilder request) {
        return given().spec(requestSpecification())
                .when()
                .pathParam("{" + request.getPathParamName() + "}", request.getPathParamValue())
                .delete(request.getPath())
                .then().log().all()
                .extract().response();
    }

    private RequestSpecification requestSpecification() {
        String baseurlForRequest = baseURL == null ? config.baseURL() : baseURL;
        return new RequestSpecBuilder()
                .setBaseUri(baseurlForRequest)
                .setAccept(ContentType.JSON)
                .setContentType(ContentType.JSON)
                .log(LogDetail.ALL)
                .build();
    }
}
