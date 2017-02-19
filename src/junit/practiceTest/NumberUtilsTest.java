package junit.practiceTest;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import junit.practice.NumberUtils;

import org.junit.Test;

public class NumberUtilsTest {

	@Test
	public void isEvenは10でtrueを返す() {
		assertThat(NumberUtils.isEven(10),is(true));
	}

	@Test
	public void isEvenは7でfalseを返す() {
		assertThat(NumberUtils.isEven(7),is(false));
	}
}
