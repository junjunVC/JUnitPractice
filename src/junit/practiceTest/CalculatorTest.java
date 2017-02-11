package junit.practiceTest;

//現在未使用のため、コメントアウト
//import static org.junit.Assert.*;

import org.junit.Test;
import junit.practice.*;

public class CalculatorTest {

	@Test(expected = IllegalArgumentException.class)
	public void divideの第2引数に0を指定するとIllegalArgumentExceptionが発生する()
		throws Exception {
		Calculator sut = new Calculator();
		sut.divide(1, 0);
	}

}
