package com.eodessa.services;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.Reporter;
import org.hamcrest.Matchers;
import io.restassured.RestAssured;
/**
 * Created by lbruksha on 10/17/17.
 */
@Test
public class TailorTest {

    @BeforeClass
    public static void setup() {
        String port = System.getProperty("server.port");
        if (port == null) {
            RestAssured.port = 443;//Integer.valueOf(6006);
        }
        else{
            RestAssured.port = Integer.valueOf(port);
        }


        String basePath = System.getProperty("server.base");
        if(basePath==null){
            basePath = "/hapi/services/2.0";
        }
        RestAssured.basePath = basePath;

        String baseHost = System.getProperty("server.host");
        if(baseHost==null){
            baseHost = "https://api.eodessa.com";
        }
        RestAssured.baseURI = baseHost;

    }

    @AfterClass
    public void tearDown()
    {
        //cleanup
    }

    @Test
    public void basicPingTest() {
        Reporter.log( RestAssured.baseURI, true );
        RestAssured.given().when().get("/tailor/id/3").then().statusCode(200);
    }

    @Test(priority = 0)
    public void GetTailorById() {
        RestAssured.given().when().get("/tailor/id/3").then()
                .body("name",Matchers.equalTo("John Tailor"))
                .body("company.id",Matchers.equalTo(1))
                .body("company.name",Matchers.equalTo("Cleaners & Alterations"))
                .statusCode(200);
    }

    @Test(priority = 1)
    public void GetTailorByCode(){
        RestAssured.given().when().get("/tailor/code/323").then()
                .body("name",Matchers.equalTo("John Tailor"))
                .body("company.id",Matchers.equalTo(1))
                .body("company.name",Matchers.equalTo("Cleaners & Alterations"))
                .statusCode(200);
    }
}
