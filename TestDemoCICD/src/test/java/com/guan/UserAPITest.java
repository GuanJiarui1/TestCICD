package com.guan;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.web.server.LocalServerPort;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

/**
 * 接口测试
 * 需要启动相关服务类
 */

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)//让Spring Boot以随机端口启动Web服务器 而不是默认不启动Web容器
public class UserAPITest {

    @LocalServerPort
    private int port;

    @BeforeEach
    public void setUp() {
        // 让 RestAssured 访问正确的端口
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = port;
    }

    @Test
    public void testUserRegister() {
        given()
                .contentType(ContentType.JSON)
                .body("{\"username\":\"testUser\", \"password\":\"password\"}")
                .when()
                .post("/api/register")
                .then()
                .statusCode(200);
    }

    @Test
    public void testUserLogin() {
        given()
                .contentType(ContentType.JSON)
                .body("{\"username\":\"testUser\", \"password\":\"111111\"}")
                .when()
                .post("/api/login")
                .then()
                .statusCode(200)
                .body(equalTo("Login success"));
    }
}

