package localhost.clients;
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import localhost.config.SpecificationFactory;

import java.util.Map;

public class AuthClient {

    public Response get(String path, String token){
        return given().spec(SpecificationFactory.requestSpec())
                .auth()
                .oauth2(token)
                .when()
                .get(path);
    }

    public Response get(String path, String token, Map<String, ?> query){
        return given().spec(SpecificationFactory.requestSpec())
                .auth()
                .oauth2(token)
                .queryParams(query)
                .when()
                .get(path);
    }

    public Response post(String path, String token, Object body){
        return given().spec(SpecificationFactory.requestSpec())
                .auth()
                .oauth2(token)
                .body(body)
                .when()
                .post(path);
    }

    public Response delete(String path, String token){
        return given().spec(SpecificationFactory.requestSpec())
                .auth()
                .oauth2(token)
                .when()
                .delete(path);
    }

    public Response put(String path, String token){
        return given().spec(SpecificationFactory.requestSpec())
                .auth()
                .oauth2(token)
                .when()
                .put(path);
    }

    public Response patch(String path, String token){
        return given().spec(SpecificationFactory.requestSpec())
                .auth()
                .oauth2(token)
                .when()
                .patch(path);
    }
}
