package api.common;

import config.Configuration;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.aeonbits.owner.ConfigCache;
import api.common.RequestBuilder;

import static io.restassured.RestAssured.given;

public class BaseApiClient {
    protected final static Configuration config = ConfigCache.getOrCreate(Configuration.class);
    public String baseURL;

    public BaseApiClient() {

    }

    public BaseApiClient(String baseURL) {
        this.baseURL = baseURL;
    }


    public Response getRequest(RequestBuilder request) {
        return given()
                .spec(requestSpecification())
                .when()
                .get(request.getPath())
                .then()
                .extract().response();
    }

    public Response getRequestWithPathParam(RequestBuilder request) {
        String pathParamName = request.getPathParams().keySet().iterator().next();
        String pathParamValue = request.getPathParams().values().iterator().next();

        return given().spec(requestSpecification())
                .when()
                .pathParam(pathParamName, pathParamValue)
                .get(request.getPath())
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

    public Response postRequest(RequestBuilder requestBuilder) {
        return given()
                .spec(requestSpecification())
                .and()
                .body(requestBuilder.getBody())
                .when()
                .post(requestBuilder.getPath())
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
