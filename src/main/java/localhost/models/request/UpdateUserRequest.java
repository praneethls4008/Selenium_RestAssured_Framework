package localhost.models.request;
import com.fasterxml.jackson.annotation.JsonInclude;
@JsonInclude(JsonInclude.Include.NON_NULL)
public record UpdateUserRequest(String email, String name, String password, String role, String avatar) {}
