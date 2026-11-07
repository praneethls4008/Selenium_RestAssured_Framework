package localhost.models.request;

@JsonInclude(JsonInclude.Include.NON_NULL)
import java.util.List;
public record UpdateProductRequest(String title, Double price, String description, Integer categoryId, List<String> images) {}
