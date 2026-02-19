package Employee;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
class EmployeeTest {
	Validator v;
	@BeforeEach
	void init() {
		v=new Validator();
	}
	@Test
	void validateInvalidNameTest1() {
		assertTrue(v.validateName("Sam Johns"));
	}
	@Test
	void validateNameInvalidTest1() {
		assertFalse(v.validateName("Jonathan"));
	}
	@Test
	void validateAgeValidTest1() {
		assertTrue(v.validateAge(18));
	}
	@Test
	void validateAgeInvalidTest1() {
		assertFalse(v.validateAge(17));	
	}
	@Test
	void validateInvalidNameTest() {
		Employee emp=new Employee("Maria",2000,25);
		assertThrows(InvalidNameException.class,()->{v.validate(emp);});
	}
	@Test
	void validateInvalidAgeTest() {
		Employee emp=new Employee("Maria Francis",2000,17);
		assertThrows(InvalidAgeException.class,()->v.validate(emp));
	}
	@Test
	void calculateAnnualSalaryValidTest1() {
		Employee emp=new Employee("Maria Francis",2000,18);
		assertEquals(25440,emp.calculateAnnualSalary());
	}
}
