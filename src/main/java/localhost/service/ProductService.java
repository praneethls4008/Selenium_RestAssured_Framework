package localhost.service;

import io.restassured.response.Response;
import localhost.clients.ApiClient;
import localhost.models.request.CreateProductRequest;
import localhost.models.request.UpdateProductRequest;

import java.util.Map;

import static localhost.constants.Endpoints.*;

public class ProductService {

    private final ApiClient client = new ApiClient();

    public Response getAll(){
        return client.get(PRODUCTS);
    }

    public Response getAll(Map<String , ?> query){
        return client.get(PRODUCTS, query);
    }

    public Response getById(int id){
        return client.get(PRODUCT_BY_ID.replace("{id}", String.valueOf(id)));
    };

    public Response getBySlug(String slug){
        return client.get(PRODUCTS_BY_SLUG.replace("{id}", slug));
    }

    public Response relatedProducts(int id) {
        return client.get(PRODUCTS_RELATED.replace("{id}", String.valueOf(id)));
    }

    public Response create(CreateProductRequest request) {
        return client.post(PRODUCTS, request);
    }
    public Response update(int id, UpdateProductRequest request) {
        return client.put(PRODUCTS_UPDATE.replace("{id}", String.valueOf(id)), request);
    }
    public Response delete(int id) {
        return client.delete(PRODUCTS_DELETE.replace("{id}", String.valueOf(id)));
    }



}
