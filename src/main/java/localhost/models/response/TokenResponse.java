package localhost.models.response;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)
public record TokenResponse(String access_token, String refresh_token) {}
