package localhost.base;
import localhost.config.Config;
import org.testng.annotations.BeforeClass;
import io.restassured.RestAssured;

public abstract class BaseTest {
    @BeforeClass(alwaysRun = true)
    public void configure() {
        RestAssured.baseURI = Config.baseUrl();
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }
}
