package junit.practiceTest;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import junit.practice.MultiLineString;

import org.junit.BeforeClass;
import org.junit.Test;

public class MultiLineStringTest {

	@Test
	public void joinで文字列が連結される_Matcherなし() {
		String lineSeparator = System.getProperty("line.separator");
		String expected = "Hello" + lineSeparator + "World" + lineSeparator;
		assertThat(MultiLineString.join("Hello", "World"), is(expected));
	}

}
