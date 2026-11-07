package localhost.models.request;
import com.fasterxml.jackson.annotation.JsonInclude;
@JsonInclude(JsonInclude.Include.NON_NULL)
public record UpdateCategoryRequest(String name, String image) {}
