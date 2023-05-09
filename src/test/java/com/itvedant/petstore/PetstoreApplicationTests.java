package com.itvedant.petstore;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PetstoreApplicationTests {

	@Test
	void contextLoads() {
	}

	private Calculator c = new Calculator();

	@Test
	void testSum(){
		int expectedResult = 15;
		int actualResult = c.getSum(12, 3);

		assertEquals(expectedResult, actualResult);
	} 
}
