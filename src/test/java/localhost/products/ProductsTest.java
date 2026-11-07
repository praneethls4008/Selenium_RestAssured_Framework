package localhost.products;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import localhost.models.Product;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

import static io.restassured.RestAssured.*;

public class ProductsTest {
    private static final String baseurl = "http://localhost:3001/api/v1/products";
    @Test
    public void getAllProducts(){
        Response response = given()
                .baseUri(baseurl)
                .accept(ContentType.JSON)
        .when()
                .get("");

        Assert.assertEquals(response.statusCode(), 200, "status code is not matching");
        Product[] getAllProductsResponse = response.as(Product[].class);

        Arrays.stream(getAllProductsResponse).forEach(System.out::println);

    }

}
