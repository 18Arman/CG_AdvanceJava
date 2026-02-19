package com.demo.calculator;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.Assert.assertThrows;
class CalculatorTest2 {
	Calculator calc;
	@BeforeEach
	void init() {
		calc=new Calculator();
	}
	@ParameterizedTest
	@CsvSource({
		"1,2,3",
		"2,3,5",
		"-1,1,0"
	})
	void testAddition(int a,int b,int expected) {
		assertEquals(expected, calc.add(a, b));
	}
	
	@ParameterizedTest
	@CsvSource(
			{
				"1,2,-1",
				"2,4,-2",
				"1,4,-3"
			})
	void testSub(int a,int b,int expected) {
		assertEquals(expected,calc.sub(a, b));
	}
	
	@ParameterizedTest
	@CsvSource(
			{
				"1,-2,-2",
				"2,0,0",
				"4,2,8"
			})
	void testMul(int a,int b,int expected) {
		assertEquals(expected,calc.mul(a, b));
	}
	
	@ParameterizedTest
	@CsvSource(
			{
				"1,2,0",
				"4,2,2",
				"4,1,4"
			})
	void testDiv(int a,int b,int expected) {
		assertEquals(expected,calc.div(a, b));
	}
	
	@ParameterizedTest
	@CsvSource(
			{
				"-1,1",
				"-2,2"
			})
	void testAbs(int a,int expected) {
		assertEquals(expected,calc.abs(a));
	}
		
}





