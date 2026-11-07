package localhost.clients;
import io.restassured.http.ContentType;
import io.restassured.response.*;
import localhost.config.SpecificationFactory;

import java.io.File;
import java.util.Map;

import static io.restassured.RestAssured.*;

public class ApiClient {


    public Response get(String path){ return given().spec(SpecificationFactory.requestSpec()).when().get(path);}

    public Response get(String path, Map<String, ?> queryParams){ return given().spec(SpecificationFactory.requestSpec()).queryParams(queryParams).when().get(path);}

    public Response post(String path, Object body){ return given().spec(SpecificationFactory.requestSpec()).body(body).when().post(path);}

    public Response put(String path, Object body) { return given().spec(SpecificationFactory.requestSpec()).body(body).when().put(path);}

    public Response delete(String path) { return given().spec(SpecificationFactory.requestSpec()).when().delete(path); }

    public Response postMultipart(String path, String fieldName, File file) {
        return given().spec(SpecificationFactory.requestSpec()).contentType("multipart/form-data")
                .multiPart(fieldName, file).when().post(path);
    }
    public Response getBinary(String path) {
        return given().spec(SpecificationFactory.requestSpec()).accept("*/*").when().get(path);
    }
}
