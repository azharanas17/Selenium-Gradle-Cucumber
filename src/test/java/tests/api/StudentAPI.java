package tests.api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class StudentAPI {
    private static final String SISWA_ENDPOINT = "/api/siswa";

    public static Response getAllStudents(String token) {
        return given()
                .header("Authorization", "Bearer " + token)
                .contentType(ContentType.JSON)
                .when()
                .get(SISWA_ENDPOINT);
    }

    public static Response getStudentById(String token, String id) {
        return given()
                .header("Authorization", "Bearer " + token)
                .when()
                .get(SISWA_ENDPOINT + "/" + id);
    }

    public static Response createStudent(String token, tests.api.models.StudentRequest body) {
        return given()
                .header("Authorization", "Bearer " + token)
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .post(SISWA_ENDPOINT);
    }

    public static Response updateStudent(String token, String id, tests.api.models.StudentRequest body) {
        return given()
                .header("Authorization", "Bearer " + token)
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .put(SISWA_ENDPOINT + "/" + id);
    }

    public static Response deleteStudent(String token, String id) {
        return given()
                .header("Authorization", "Bearer " + token)
                .when()
                .delete(SISWA_ENDPOINT + "/" + id);
    }
}
