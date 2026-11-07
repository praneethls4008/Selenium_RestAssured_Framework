package localhost.products;

import localhost.base.BaseTest;
import localhost.service.ProductService;
import org.testng.annotations.Test;

import java.util.Map;

public class ProductQueryTests extends BaseTest {
    private final ProductService products = new ProductService();

    @Test
    public void getAll(){
        products.getAll();
    }

    @Test
    public void filterProductsByCategory() {
        products.getAll(Map.of("categoryId", 1))
                .then()
                .statusCode(200);
    }
}
