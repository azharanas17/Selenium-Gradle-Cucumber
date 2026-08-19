package tests.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import tests.api.AuthAPI;
import tests.api.StudentAPI;
import tests.api.BaseApiTest;
import tests.api.models.RegisterRequest;
import tests.api.models.StudentRequest;

import io.cucumber.datatable.DataTable;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class ApiSteps {

    private Response response;
    private String token;

    @Given("Saya melakukan POST request register dengan nama {string} email {string} dan password {string}")
    public void sayaMelakukanPostRequestRegister(String nama, String email, String password) {
        BaseApiTest.setup();
        RegisterRequest body = new RegisterRequest(nama, email, password);
        response = AuthAPI.register(body);
    }

    @Given("Saya melakukan POST request login dengan email {string} dan password {string}")
    public void sayaMelakukanPostRequestLogin(String email, String password) {
        BaseApiTest.setup();
        response = AuthAPI.login(email, password);
        if (response.getStatusCode() == 200) {
            token = response.path("data.token");
        }
    }

    @Given("Saya melakukan login terlebih dahulu")
    public void sayaMelakukanLoginTerlebihDahulu() {
        BaseApiTest.login();
        token = BaseApiTest.token;
    }

    @When("Saya melakukan GET request {string} dengan token")
    public void sayaMelakukanGetRequestDenganToken(String endpoint) {
        response = RestAssured.given()
                .header("Authorization", "Bearer " + token)
                .baseUri("https://api.rizqifauzan.com")
                .when()
                .get(endpoint);
    }

    @When("Saya melakukan POST request logout dengan token")
    public void sayaMelakukanPostRequestLogoutDenganToken() {
        response = AuthAPI.logout(token);
    }

    @When("Saya melakukan POST request {string} dengan token dan body siswa:")
    public void sayaMelakukanPostRequestDenganTokenDanBodySiswa(String endpoint, DataTable dataTable) {
        StudentRequest body = new StudentRequest(
                dataTable.cell(1, 0),
                dataTable.cell(1, 1),
                dataTable.cell(1, 2),
                dataTable.cell(1, 3),
                dataTable.cell(1, 4),
                dataTable.cell(1, 5),
                dataTable.cell(1, 6));
        response = StudentAPI.createStudent(token, body);
    }

    @Then("Status code adalah {int}")
    public void statusCodeAdalah(int expectedStatusCode) {
        assertEquals(expectedStatusCode, response.getStatusCode());
    }

    @Then("Response body memiliki field {string} dengan nilai true")
    public void responseBodyMemilikiFieldDenganNilaiTrue(String fieldName) {
        Boolean actualValue = response.jsonPath().getBoolean(fieldName);
        assertEquals(true, actualValue);
    }

    @Then("Response body memiliki field {string} dengan nilai false")
    public void responseBodyMemilikiFieldDenganNilaiFalse(String fieldName) {
        Boolean actualValue = response.jsonPath().getBoolean(fieldName);
        assertEquals(false, actualValue);
    }

    @Then("Response body memiliki field {string} dengan nilai {string}")
    public void responseBodyMemilikiFieldDenganNilai(String fieldName, String expectedValue) {
        String actualValue = response.jsonPath().getString(fieldName);
        assertEquals(expectedValue, actualValue);
    }

    @Then("Response body memiliki field {string} tidak null")
    public void responseBodyMemilikiFieldTidakNull(String fieldName) {
        Object actualValue = response.jsonPath().get(fieldName);
        assertNotNull(actualValue, "Field '" + fieldName + "' should not be null");
    }
}
