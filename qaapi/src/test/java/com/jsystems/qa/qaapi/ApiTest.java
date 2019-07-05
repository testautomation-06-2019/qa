package com.jsystems.qa.qaapi;

import com.jsystems.qa.qaapi.database.UserDao;
import com.jsystems.qa.qaapi.model.error.ErrorResponse;
import com.jsystems.qa.qaapi.model.user.MyUser;
import com.jsystems.qa.qaapi.model.device.User;
import com.jsystems.qa.qaapi.model.user.UserAzure;
import com.jsystems.qa.qaapi.model.user.UserDb;
import com.jsystems.qa.qaapi.service.ApiService;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.google.common.truth.Truth.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

@DisplayName("Api tests")
public class ApiTest {

    @Test
    public void firstApiTest() {
        RestAssured
                .given()
                .get("http://www.mocky.io/v2/5a6b69ec3100009d211b8aeb")
                .then()
                .assertThat()
                .statusCode(200)
                .body("name", equalTo("Piotr"))
                .body("surname", equalTo("Kowalski"));
    }

    @Test
    public void nestedJsonTest() {
        RestAssured
                .given()
                .get("http://www.mocky.io/v2/5a6a58222e0000d0377a7789")
                .then()
                .assertThat()
                .statusCode(200)
                .body("[0].imie", notNullValue())
                .body("[0].imie", equalTo("Piotr"))
                .body("[0].nazwisko", notNullValue())
                .body("[0].nazwisko", equalTo("Kowalski"));
//                .body("[0].device[0].device.model.produce", equalTo("Kowalski"));
    }

    @Test
    @DisplayName("First test with mapping to jsonPath")
    public void jsonPathTest() {

        List<User> users = ApiService.getUsers();

        assertThat(users.get(0).imie).isEqualTo("Piotr");
        assertThat(users.get(0).nazwisko).isEqualTo("Kowalski");
        assertThat(users.get(0).device.get(0).type).isEqualTo("computer");
        assertThat(users.get(0).device.get(0).deviceModel.get(0).produce).isEqualTo("dell");
        assertThat(users.get(0).device.get(0).deviceModel.get(0).screenSize).isEqualTo(17);

    }

//    @ParameterizedTest(name = "Parameterized test with values name: {0} and value: {1}")
//    @CsvSource(value = {"Piotr, Kowalski", "Adam, Konarski"}, delimiter = ',')
    @Test
    @DisplayName("Test with mapped of MyUser")
    public void myUserJsonPath() {
        MyUser myUserWithQuery = ApiService.getUserWithQueryParam("Piotr",  "Kowalski");
        MyUser myUserWitrhPathVariable = ApiService.getUserWithPathVariable(2L,  5);
        MyUser myUser = ApiService.getUser();

        assertThat(myUser.name).isEqualTo("Piotr");
        assertThat(myUser.surname).isEqualTo("Kowalski");

        assertThat(myUserWithQuery.name).isEqualTo("Piotr");
    }

    @Test
    @DisplayName("Post test")
    public void postTest() {
        String[] strings = ApiService.postMyUser(new MyUser("Piotr", "Kowalski"));
        assertThat(strings).isEmpty();
    }

    @Test
    @DisplayName("Error response")
    public void errorResponse() {
        ErrorResponse errorResponse = ApiService.getErrorResponse();

        assertThat(errorResponse.error.errorCode).isEqualTo(400);
        assertThat(errorResponse.error.validationError).isEqualTo("invalid_email");
        assertThat(errorResponse.error.message).isEqualTo("your email is invalid");
    }

    @Test
    public void azureUser(){

        UserAzure userAzure = ApiService.getUserAzureById(1);

        assertThat(userAzure.id).isEqualTo(1);
        assertThat(userAzure.userName).isEqualTo("User 1");
        assertThat(userAzure.password).isEqualTo("Password1");
    }

    @Test
    @Disabled
    public void dbTest() {
        UserDb userDb = UserDao.getOneById(1L);
        assertThat(userDb.getName()).isEqualTo("Piotr");
    }

}
