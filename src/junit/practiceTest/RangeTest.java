package junit.practiceTest;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import junit.practice.Range;

import org.junit.Test;

public class RangeTest {


	@Test
	public void containsのテスト() {
		assertThat(new Range(0d,10.5).contains(-0.1), is(false));
		assertThat(new Range(0d,10.5).contains(0.0),  is(true));
		assertThat(new Range(0d,10.5).contains(0.0),  is(true));
		assertThat(new Range(0d,10.5).contains(10.6), is(false));

		assertThat(new Range(-5.1,5.1).contains(-5.2), is(false));
		assertThat(new Range(-5.1,5.1).contains(-5.1), is(true));
		assertThat(new Range(-5.1,5.1).contains(5.1),  is(true));
		assertThat(new Range(-5.1,5.1).contains(5.2), is(false));
	}

}
