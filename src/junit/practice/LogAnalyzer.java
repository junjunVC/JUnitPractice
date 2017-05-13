package junit.practice;

import java.io.IOException;
import java.util.Map;

public class LogAnalyzer {
	public LogLoader logLoader = new LogLoader();

	public Object analyze(String file) {
		try {
			Map<String, String> rawData = logLoader.load(file);
			return doAnalyze(rawData);
		} catch (IOException e) {
			throw new AnalyzeException(e);
		}
	}

	private Object doAnalyze(Map<String, String> rawData) {
		// これは仮実装です
		return new Object();
	}

	public static class AnalyzeException extends RuntimeException {
		public AnalyzeException(Throwable cause) {
			super(cause);
		}
	}
}
