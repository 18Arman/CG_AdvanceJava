package in.cg.operationTest;
import static org.junit.Assert.*;

import org.junit.Test;

import in.cg.operation.EmployeeSalaryCalculator;

public class EmployeeSalaryCalculatorTest {
	@Test
	public void validSalaryTest() {
		EmployeeSalaryCalculator calculator = new EmployeeSalaryCalculator(50000, 5000, 10);
		double result=calculator.calculateNetSalary();
		assertTrue(63000==result);
	}
	@Test
	public void invalidSalaryTest() {
		assertThrows(IllegalArgumentException.class, () -> new EmployeeSalaryCalculator(-50000, 5000, 10));
	}
	@Test
	public void invalidTaxTest() {
		assertThrows(IllegalArgumentException.class, () -> new EmployeeSalaryCalculator(50000, 5000, -10));
	}
}
