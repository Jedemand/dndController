package com.example.dndcontroller;

import com.example.dndcontroller.repos.services.ComplexCharService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasKey;

@SpringBootTest
@AutoConfigureMockMvc
class DndControllerApplicationTests {

    @Autowired
    ComplexCharService complexCharService;

    @Test
    void contextLoads() {
    }
    @Test
    public void checkEndpoint(){
        get("/actor/")
                .then()
                .statusCode(200);
    }



}
