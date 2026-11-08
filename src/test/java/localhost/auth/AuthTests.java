package localhost.auth;

import localhost.base.BaseTest;
import localhost.clients.AuthClient;
import localhost.models.request.LoginRequest;
import localhost.models.response.ProfileResponse;
import localhost.models.response.TokenResponse;
import localhost.service.AuthService;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthTests extends BaseTest {
    private AuthService service = new AuthService();

    @Test
    public void loginTest(){
        TokenResponse tokens = service.login(new LoginRequest("john@mail.com", "changeme"))
                .then()
                .statusCode(201)
                .extract().as(TokenResponse.class);

        Assert.assertNotNull(tokens.access_token());
        Assert.assertNotNull(tokens.refresh_token());
    }

    @Test
    public void authenticatedUserCanReadProfile(){

        String email = "john@mail.com";
        TokenResponse tokens =service.login(new LoginRequest(email, "changeme"))
                .then()
                .statusCode(201)
                .extract().as(TokenResponse.class);

        Assert.assertNotNull(tokens.access_token());
        Assert.assertNotNull(tokens.refresh_token());

        ProfileResponse profile = service.profile(tokens.access_token())
                .then()
                .statusCode(200)
                .extract()
                .as(ProfileResponse.class);

        Assert.assertEquals(profile.email(), email);
        Assert.assertEquals(profile.role(), "customer");


    }

}
