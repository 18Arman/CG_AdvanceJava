package com.practiceQ1;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
class UserServiceTest {
	UserService us;
	@BeforeEach
	void init() {
		us=new UserService();
	}
	@Test
	void validRegisTest() {
		assertTrue(()->us.registerUser("Arman", "arman@123"));
	}
	@Test
	void invalidUserNameTest() {
		assertThrows(InvalidUserNameException.class,()->us.registerUser(null,"InvalidPassword"));
	}
	@Test
	void weakPasswordTest() {
		assertThrows(InvalidPasswordException.class,()->us.registerUser("Arman", "weak"));
	}
	@Test
	void validFullUserTest() {
		assertAll(
				()->assertDoesNotThrow(()->us.registerUser("Arman","Arman@123")),
				()->assertDoesNotThrow(()->us.registerUser("Arman","weak@123"))
			);
	}
	@Test
	void InvalidFullUserTest() {
		assertAll(
				()->assertThrows(InvalidUserNameException.class,()->us.registerUser(null,"weak")),
				()->assertThrows(InvalidPasswordException.class,()->us.registerUser("Arman","234"))
				);
		
	}
}
