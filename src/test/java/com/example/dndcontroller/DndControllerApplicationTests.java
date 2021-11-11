package com.example.dndcontroller;

import com.example.dndcontroller.models.Actor;
import com.example.dndcontroller.models.Weapon;
import com.example.dndcontroller.repos.services.ActorService;
import net.minidev.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasKey;

@SpringBootTest
@AutoConfigureMockMvc
class DndControllerApplicationTests {

    @Autowired
    ActorService actorService;

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
