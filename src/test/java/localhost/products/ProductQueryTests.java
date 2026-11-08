package localhost.products;

import localhost.base.BaseTest;
import localhost.service.ProductService;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

public class ProductQueryTests extends BaseTest {
    private final ProductService products = new ProductService();

    @Test
    public void getAll(){
        products.getAll(Map.of("limit", 5, "offset", 0))
                .then()
                .statusCode(200)

                .body("size()", greaterThanOrEqualTo(0))
                .body("[0].id", instanceOf(Integer.class))
                .body("[0].title", instanceOf(String.class))
                .body("[0].slug", instanceOf(String.class))
                .body("[0].price", instanceOf(Number.class))
                .body("[0].description", instanceOf(String.class))
                .body("[0].category.id", instanceOf(Integer.class))
                .body("[0].category.name", instanceOf(String.class))
                .body("[0].category.slug", instanceOf(String.class))
                .body("[0].category.image", instanceOf(String.class))
                .body("[0].images", allOf(instanceOf(List.class), everyItem(instanceOf(String.class))))
                .body("[0].creationAt", instanceOf(String.class))
                .body("[0].updatedAt", instanceOf(String.class));
    }

    @Test
    public void filterProductsByCategory() {
        products.getAll(Map.of("categoryId", 1))
                .then()
                .statusCode(200);
    }
}
