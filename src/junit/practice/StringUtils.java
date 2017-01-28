package junit.practice;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {
	public static String toSnakeCase(String sourceString) {
		if (sourceString == null) {
			throw new NullPointerException("sourceString == null");
		}
		String snake = sourceString;
		Pattern pattern = Pattern.compile("([A-Z])");
		for(;;) {
			Matcher matcher = pattern.matcher(snake);
			if (!matcher.find()) {
				break;
			}
			snake = matcher.replaceFirst("_" + matcher.group(1).toLowerCase());
		}

		return snake.replaceFirst("^_", "");
	}
}
