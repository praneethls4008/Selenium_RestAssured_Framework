package localhost.config;

import io.restassured.builder.*;
import io.restassured.http.ContentType;
import io.restassured.specification.*;
import io.restassured.filter.log.*;

import java.util.concurrent.TimeUnit;

public final class SpecificationFactory {
     private SpecificationFactory() {}
     public static RequestSpecification requestSpec() {
          return new RequestSpecBuilder()
                  .setBaseUri(Config.baseUrl())
                  .setContentType(ContentType.JSON)
                  .setAccept(ContentType.JSON)
                  .addHeader("User-Agent", "platzi-rest-assured-automation/1.0")
                  .addFilter(new RequestLoggingFilter())
                  .addFilter(new ResponseLoggingFilter())
                  .addFilter(new ErrorLoggingFilter())
                  .build();
     }
     public static ResponseSpecification successSpec() {
          return new ResponseSpecBuilder().expectResponseTime(
                  org.hamcrest.Matchers.lessThan(15000L), TimeUnit.MILLISECONDS).build();
     }
}
