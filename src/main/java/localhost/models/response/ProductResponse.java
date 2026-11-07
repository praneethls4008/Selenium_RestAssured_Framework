package localhost.models.response;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
public record ProductResponse(Integer id, String title, String slug, Double price,
                              String description, CategoryResponse category, List<String> images,
                              String creationAt, String updatedAt) {}
