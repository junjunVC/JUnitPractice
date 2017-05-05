package junit.practiceTest;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import junit.practice.Range;

import org.junit.Before;
//import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class RangeTest {


/*	@Test
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
*/

	@RunWith(Enclosed.class)
	public static class Rangeが0から10_5で {
		@RunWith(Theories.class)
		public static class かつ範囲外の場合 {
			Range sut;

			@Before
			public void setUp() {
				sut = new Range(0d, 10.5);
			}

			@DataPoints
			public static double[] VALUES = {-0.1, 10.6};

			@Theory
			public void containsはfalseを返す(double value) throws Exception {
				assertThat("value=" + value, sut.contains(value),is(false));
			}
		}

		@RunWith(Theories.class)
		public static class かつ範囲内の場合 {
			Range sut;

			@Before
			public void setUp() {
				sut = new Range(0d, 10.5);
			}

			@DataPoints
			public static double[] VALUES = {0.0, 10.5};

			@Theory
			public void containsはtrueを返す(double value) throws Exception {
				assertThat("value=" + value, sut.contains(value),is(true));
			}
		}
	}


}
