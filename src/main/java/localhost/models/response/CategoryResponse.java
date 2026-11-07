package localhost.models.response;
import com.fasterxml.jackson.annotation.*;


@JsonIgnoreProperties(ignoreUnknown = true)
public record CategoryResponse(Integer id, String name, String slug, String image,
                               String creationAt, String updatedAt) {}
