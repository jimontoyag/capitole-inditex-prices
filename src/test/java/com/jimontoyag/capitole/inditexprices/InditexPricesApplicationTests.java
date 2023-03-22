package com.jimontoyag.capitole.inditexprices;

import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
abstract class InditexPricesApplicationTests {

	 @Autowired private MockMvc mockMvc;

	@BeforeAll
	void setup(){
		RestAssuredMockMvc.mockMvc(mockMvc);

	}

	@Test
	void contextLoads() {
	}

}
