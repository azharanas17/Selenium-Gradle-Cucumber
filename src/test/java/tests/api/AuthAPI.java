package tests.api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class AuthAPI {

    public static Response register(tests.api.models.RegisterRequest body) {
        return given()
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .post("/api/auth/register");
    }

    public static Response login(String email, String password) {
        tests.api.models.LoginRequest body = new tests.api.models.LoginRequest(email, password);
        return given()
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .post("/api/auth/login");
    }

    public static Response logout(String token) {
        return given()
                .header("Authorization", "Bearer " + token)
                .when()
                .post("/api/auth/logout");
    }

    public static Response getMe(String token) {
        return given()
                .header("Authorization", "Bearer " + token)
                .when()
                .get("/api/auth/me");
    }
}
