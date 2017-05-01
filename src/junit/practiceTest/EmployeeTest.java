package junit.practiceTest;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.*;

import java.io.InputStream;
import java.util.List;

import junit.practice.Employee;

import org.junit.Test;

public class EmployeeTest {

	@Test
	public void loadでEmployeeの一覧を取得できる() {
		// SetUp
		InputStream input = getClass().getResourceAsStream("Employee.txt");

		//Exercise
		List<Employee> actual = Employee.load(input);
		//Verify
		assertThat(actual, is(notNullValue()));
		assertThat(actual.size(), is(1));
		Employee actualEmployee = actual.get(0);
		assertThat(actualEmployee.getFirstName(), is("Ichiro"));
		assertThat(actualEmployee.getLastName(), is("Tanaka"));
		assertThat(actualEmployee.getEmail(), is("ichiro@example.com"));
	}

}
