package com.demo.calculator;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

class CalculatorTest3 {
	Calculator calc;
	@BeforeEach
	void init() {
		calc=new Calculator();
	}
	@ParameterizedTest
	@CsvFileSource( resources="TestData2.csv",numLinesToSkip=0)
	void testAdditionFromFile(int a,int b,int expected) {
		assertEquals(expected,calc.add(a, b));
	}
}
