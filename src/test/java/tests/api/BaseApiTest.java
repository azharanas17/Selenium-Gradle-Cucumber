package tests.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import tests.api.utils.ConfigReader;

public class BaseApiTest {
    public static String token;

    public static void setup() {
        RestAssured.baseURI = ConfigReader.getProperty("base_url");
    }

    public static void login() {
        setup();
        Response response = AuthAPI.login("hrzpitulas17@gmail.com", "APIPracticehrzpitulas17.");
        if (response.getStatusCode() == 200) {
            token = response.path("data.token");
        }
    }
}
