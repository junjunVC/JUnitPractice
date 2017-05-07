package junit.practice;

import java.util.Calendar;

public class MonthlyCalendar {

	private final Calendar cal;

	MonthlyCalendar() {
		this(Calendar.getInstance());
	}

	public MonthlyCalendar(Calendar cal) {
		this.cal = cal;
	}

	public int getRemainingDays() {
		return cal.getActualMaximum(Calendar.DATE) - cal.get(Calendar.DATE);
	}
}
