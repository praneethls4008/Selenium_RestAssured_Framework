package localhost.models.response;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)
public record UploadResponse(String originalname, String filename, String location) {}
