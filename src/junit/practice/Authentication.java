package junit.practice;

public class Authentication {

	public AccountDao dao = null;

	public Account authenticate(String userId, String password) {
		assert dao != null;

		Account account = dao.findOrNull(userId);

		if(account == null) {
			return null;
		}

		return account.getPassword().equals(password) ? account : null;	}
}
