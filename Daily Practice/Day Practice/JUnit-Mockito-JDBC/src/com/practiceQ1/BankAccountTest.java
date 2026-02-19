package com.practiceQ1;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
class BankAccountTest {
	BankAccount b1;
	@BeforeEach
	void init() {
		b1=new BankAccount();
	}
	@Test
	void validBalanceTest() {
		assertTrue(()->b1.deposit(1000));
	}
	@Test
	void invalidBalanceTest() {
		assertFalse(()->b1.withdraw(4000));
	}
	@Test
	void invalidDepositTest() {
		assertThrows(InvalidAmountException.class,()->b1.deposit(-1000));
	}
}
