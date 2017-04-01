package junit.practice;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {
	public static List<String> createFizzBuzzList(int number) {
		List<String> result = new ArrayList<String>();

		//1未満は空のリストを返す
		if (number < 1) {
			return result;
		}

		for(int i = 1; i<=number; i++) {
			//3の倍数かつ5の倍数の場合は、"FizzBuzz"を返す
			if (i % 15 == 0) {
				result.add("FizzBuzz");
				continue;
			}

			//5の倍数の場合は、"Buzz"を返す
			if (i % 5 == 0) {
				result.add("Buzz");
				continue;
			}

			//3の倍数の場合は、"Fizz"を返す
			if (i % 3 == 0) {
				result.add("Fizz");
				continue;
			}

			//それ以外の場合は、その値を返す
			result.add(Integer.toString(i));
		}

		return result;
	}

}
