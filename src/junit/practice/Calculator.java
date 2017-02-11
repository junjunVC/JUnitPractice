package junit.practice;

public class Calculator {
	public int divide(int a, int b) {
		if (b == 0) {
			throw new IllegalArgumentException();
		}
		return a/b;
	}
}
