package data;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;

public class SnacksEqualsTest {
	private void isEqual(Snacks a, Snacks b) {
		assertEquals(a, b);
	}

	private void isNotEqual(Snacks a, Snacks b) {
		assertThat(a, not(equalTo(b)));
	}

	@Test
	public void equalsTest() {
		Snacks a = new Snacks("Skittles");
		Snacks b = new Snacks("Skittles");
		Snacks c = new Snacks();
		isEqual(a, b);
		isNotEqual(b, c);
		int e = 0;
	
	}
}
