package com.operations;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
class OperationsTest {
	Operations op;
	@BeforeEach
	void init(){
		op=new Operations();
	}
	@Test
	void factorialedge() {
		assertEquals(0,op.factorial(0));
		assertEquals(1,op.factorial(1));
	}
	@Test
	void factorialgeneral() {
		assertEquals(120,op.factorial(5));
	}
	@Test
	void validateUserTrue() {
		assertTrue(op.validateUser("arman", "123@"));
	}
	@Test
	void validateUserFalse() {
		assertFalse(op.validateUser("sanat", "123@"));
		assertFalse(op.validateUser("arman","123" ));
	}
}
