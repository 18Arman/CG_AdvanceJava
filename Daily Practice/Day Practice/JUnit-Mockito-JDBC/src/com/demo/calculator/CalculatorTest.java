package com.demo.calculator;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
class CalculatorTest {
	Calculator cal;
	@BeforeEach
	void init() {
		cal=new Calculator();
	}
	@Test
	void testAdd() {
		int result=cal.add(2, 3);
		assertEquals(5,result);
	}
	@Test
	void testSub() {
		assertEquals(3,cal.sub(5, 2));
	}
	@Test
	void division() {
		assertEquals(5,cal.div(10,2));
	}
	@Test
	void shouldThrowExceptionWhenDividingByZero() {
		assertThrows(IllegalArgumentException.class,()->{
			cal.div(10,0);
		});
	}
	@Test
	void multiple() {
		assertEquals(50,cal.mul(10,5));
	}

}
