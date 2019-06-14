package com.jsystems.qa.qaapi.specification;

import com.jsystems.qa.qaapi.configuration.ApiConfig;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class Specification {
        private static final String V2 = "v2";

    public static RequestSpecification requestSpecBuilder() {
        return new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri(ApiConfig.BASE_URL)
                .setBasePath(V2)
                .build();
    }

    public static RequestSpecification requestSpecBuilderWithAuthorisation(String auth) {
        return new RequestSpecBuilder()
                .addHeader("Authorise", "ApiKey, " + auth)
                .setContentType(ContentType.JSON)
                .setBaseUri(ApiConfig.BASE_URL)
                .setBasePath(V2)
                .build();
    }

    public static RequestSpecification fakeAzureSpecBuilder() {
        return new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri("http://fakerestapi.azurewebsites.net")
                .build();
    }
}
