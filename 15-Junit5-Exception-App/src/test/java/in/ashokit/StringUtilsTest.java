package in.ashokit;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class StringUtilsTest {

	@Test
	public void stringToIntTest() {
		StringUtils stu = new StringUtils();
		assertThrows(IllegalArgumentException.class, () -> stu.stringToInt(null));
	}
}
