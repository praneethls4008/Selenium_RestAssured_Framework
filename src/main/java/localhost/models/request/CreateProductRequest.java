package localhost.models.request;
import java.util.List;
public record CreateProductRequest(String title, double price, String description, int categoryId, List<String> images) {}
