package junit.practice;

import java.util.HashMap;

public class ItemStock {
	private HashMap<String,Integer> values = new HashMap<String,Integer>();

	public void add(Item item) {
		Integer number = values.get(item.name);
		if (number == null) {
			number = 0;
		}
		number++;
		values.put(item.name, number);
	}

	public int getNum(Item item) {
		Integer number = values.get(item.name);
		if (number == null) {
			return 0;
		} else {
			return number;
		}
	}
}
