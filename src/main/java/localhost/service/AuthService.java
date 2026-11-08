package localhost.service;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import localhost.clients.ApiClient;
import localhost.clients.AuthClient;
import localhost.constants.Endpoints;
import localhost.models.request.LoginRequest;
import localhost.models.request.RefreshTokenRequest;

public class AuthService {
    private final ApiClient client = new ApiClient();
    private final AuthClient authClient = new AuthClient();

    public Response login(LoginRequest request){
        return client.post(Endpoints.LOGIN, request);
    }

    public Response profile(String token){
        return authClient.get(Endpoints.PROFILE, token);
    }

    public Response refresh(String refreshToken){
        return client.post(Endpoints.REFRESH, new RefreshTokenRequest(refreshToken));
    }

}
