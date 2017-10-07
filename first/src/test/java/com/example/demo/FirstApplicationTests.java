package com.example.demo;

import static com.jayway.restassured.RestAssured.given;
import static com.jayway.restassured.RestAssured.when;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.example.demo.*;

import com.jayway.restassured.RestAssured;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = FirstApplication.class)
@WebAppConfiguration
@IntegrationTest({"server.port:0",
        "spring.datasource.url:jdbc:h2:mem:projectName;DB_CLOSE_ON_EXIT=FALSE"})
public class FirstApplicationTests {
	 @Value("${local.server.port}")
	    int port;

	    @Before
	    public void setUp() throws Exception {
	        RestAssured.port = port;
	    }
	    @Test
	    public void testCalc() throws Exception {
	        given().param("left", 100)
	                .param("right", 200)
	                .get("/calc")
	                .then()
	                .body("left", is(100))
	                .body("right", is(200))
	                .body("answer", is(300));
	    }
	 @Test
	    public void testHello() throws Exception {
	        when().get("/Naveen").then()
	                .body(is("Hello World!"));
	    }
	 

}
