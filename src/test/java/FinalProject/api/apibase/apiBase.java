package FinalProject.api.apibase;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class apiBase {
    private static final String BASE_URI = "https://dummyapi.io/data/v1/";
    private static final String APP_ID = "63a804408eb0cb069b57e43a";

    public static RequestSpecification getRequest() {
        return new RequestSpecBuilder()
                .setBaseUri(BASE_URI)
                .addHeader("app-id", APP_ID)
                .setContentType(ContentType.JSON)
                .addFilter(new RequestLoggingFilter())
                .addFilter(new ResponseLoggingFilter())
                .build();

    }
}
