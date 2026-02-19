package Palindrome;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
class PalindromeTest {
	Palindrome p;
	@BeforeEach
	void init(){
		p=new Palindrome();
	}
	@Test
	void palindromeTest() {
		assertTrue(p.isPalindrome(101));
	}
}
