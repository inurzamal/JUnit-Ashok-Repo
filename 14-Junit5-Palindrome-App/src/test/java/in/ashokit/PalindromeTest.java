package in.ashokit;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class PalindromeTest {

	@ParameterizedTest
	@ValueSource(strings = { "racecar", "liril", "madam", "ashok" })
	public void isPalindromeTest(String str) {
		PalindromeCheck pc = new PalindromeCheck();
		boolean actual = pc.isPalidrome(str);
		assertTrue(actual);
	}
}
