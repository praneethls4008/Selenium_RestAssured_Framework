package localhost.models.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record UpdateProductRequest(
        String title,
        Double price,
        String description,
        Integer categoryId,
        List<String> images
) {}
