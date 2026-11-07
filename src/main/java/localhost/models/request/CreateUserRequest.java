package localhost.models.request;
public record CreateUserRequest(String email, String name, String password, String role, String avatar) {}
