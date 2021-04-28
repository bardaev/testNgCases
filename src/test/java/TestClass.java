import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class TestClass {

    final static String path = "src/test/resources/";
    final static String fileName= "testdata.json";
    final static String URL = "http://users.bugred.ru/tasks/rest/createuser";
    static TestData testData;
    final static ObjectMapper objectMapper = new ObjectMapper();

    @BeforeSuite
    public void setUp() throws IOException {
        byte[] data = Files.readAllBytes(Paths.get(path, fileName));
        testData = objectMapper.readValue(data, TestData.class);
    }

    @DataProvider(name = "data")
    public Object[][] create() {
        Object[][] result = new Object[1][1];

        String email = RandomStringUtils.randomAlphabetic(8) + "@mail.ru";
        String name = RandomStringUtils.randomAlphabetic(8);
        List<Integer> tasks = new ArrayList<>();
        tasks.add(12);
        List<Integer> companies = new ArrayList<>();
        companies.add(36);
        companies.add(37);
        String hobby = RandomStringUtils.randomAlphabetic(10);
        Double phoneDouble = Math.random() * 10000000;
        String phone = String.valueOf(phoneDouble.intValue());
        long inn = RandomUtils.nextLong(100000000000L, 999999999999L);

        testData.setEmail(email.toLowerCase());
        testData.setName(name);
        testData.setTasks(tasks);
        testData.setCompanies(companies);
        testData.setHobby(hobby);
        testData.setPhone(phone);
        testData.setInn(String.valueOf(inn));

        result[0][0] = testData;

        return result;
    }

    @Test(dataProvider = "data")
    public void testCreateUser(Object o) throws IOException {
        TestData data = (TestData) o;

        String json = objectMapper.writeValueAsString(data);

        Response response = RestAssured.given()
                .header("Content-Type", "application/json")
                .body(json)
                .when()
                .post(URL);

        JsonPath jsonPath = response.getBody().jsonPath();

        Steps.checkName(jsonPath.getString("name"), data.name);
        Steps.checkEmail(jsonPath.getString("email"), data.email);
        Steps.checkHobby(jsonPath.getString("hobby"), data.hobby);
        Steps.checkPhone(jsonPath.getString("phone"), data.phone);
    }

    @Test(dataProvider = "data")
    public void testCreateDifferentNameAndEmail(Object o) throws IOException {
        TestData data = (TestData) o;

        String json1 = objectMapper.writeValueAsString(data);

        data.setName(RandomStringUtils.randomAlphabetic(8));
        data.setEmail(RandomStringUtils.randomAlphabetic(8) + "@mail.ru");
        String json2 = objectMapper.writeValueAsString(data);

        RestAssured.given()
                .header("Content-Type", "application/json")
                .body(json1)
                .when()
                .post(URL);

        Response response1 = RestAssured.given()
                .header("Content-Type", "application/json")
                .body(json2)
                .when()
                .post(URL);

        Steps.checkError(response1.jsonPath().getString("type"));
    }

    @Test(dataProvider = "data")
    public void testCreateSameEmail(Object o) throws IOException {
        TestData data = (TestData) o;

        String json1 = objectMapper.writeValueAsString(data);

        data.setName(RandomStringUtils.randomAlphabetic(8));
        String json2 = objectMapper.writeValueAsString(data);

        RestAssured.given()
                .header("Content-Type", "application/json")
                .body(json1)
                .when()
                .post(URL);

        Response response1 = RestAssured.given()
                .header("Content-Type", "application/json")
                .body(json2)
                .when()
                .post(URL);

        Steps.checkError(response1.jsonPath().getString("type"), "error");
    }

    @Test(dataProvider = "data")
    public void testCreateSameName(Object o) throws IOException {
        TestData data = (TestData) o;

        String json1 = objectMapper.writeValueAsString(data);

        data.setEmail(RandomStringUtils.randomAlphabetic(8) + "@mail.ru");
        String json2 = objectMapper.writeValueAsString(data);

        RestAssured.given()
                .header("Content-Type", "application/json")
                .body(json1)
                .when()
                .post(URL);

        Response response1 = RestAssured.given()
                .header("Content-Type", "application/json")
                .body(json2)
                .when()
                .post(URL);

        Steps.checkError(response1.jsonPath().getString("type"), "error");
    }

    @Test(dataProvider = "data")
    public void testWrongInn(Object o) throws IOException {
        TestData data = (TestData) o;

        data.setInn("123");
        String json = objectMapper.writeValueAsString(data);

        Response response = RestAssured.given()
                .header("Content-Type", "application/json")
                .body(json)
                .when()
                .post(URL);

        Steps.checkError(response.jsonPath().getString("type"), "error");
    }

    @Test(dataProvider = "data")
    public void testWrongEmail(Object o) throws IOException {
        TestData data = (TestData) o;

        data.setEmail("abc");
        String json = objectMapper.writeValueAsString(data);

        Response response = RestAssured.given()
                .header("Content-Type", "application/json")
                .body(json)
                .when()
                .post(URL);

        Steps.checkError(response.jsonPath().getString("type"), "error");
    }
}
