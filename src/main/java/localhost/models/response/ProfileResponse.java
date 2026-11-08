package localhost.models.response;

import java.time.Instant;

public record ProfileResponse(
        Integer id,
        String email,
        String password,
        String name,
        String role,
        String avatar,
        String creationAt,
        String updatedAt
)
{ }
