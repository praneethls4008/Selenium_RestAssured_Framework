package localhost.models.response;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)
public record UserResponse(Integer id, String email, String name, String role, String avatar,
                           String creationAt, String updatedAt) {}
