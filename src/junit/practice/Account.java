package junit.practice;

public class Account {
	private String name;
	private String password;

	public String getName() {
		return this.name;
	}

	public String getPassword() {
		return this.password;
	}

	public Account(String name, String password) {
		this.name     = name;
		this.password = password;
	}
}
