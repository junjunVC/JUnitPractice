package junit.practiceTest;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import junit.practice.Account;
import junit.practice.AccountDao;
import junit.practice.Authentication;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class AuthenticationTest {

	public static class アカウントが存在しない場合 {
		Authentication sut;

		@Before
		public void setUp() {
			sut = new Authentication();
			sut.dao = mock(AccountDao.class);
			when(sut.dao.findOrNull("testUser001")).thenReturn(null);
		}

		@Test
		public void authenticationはnullを返す() throws Exception {
			assertThat(sut.authenticate("testUser001", "pwd123"), is(nullValue()));
		}
	}


	public static class アカウントが存在しパスワードが一致する場合 {
		Authentication sut;
		Account account;

		@Before
		public void setUp() {
			sut = new Authentication();
			sut.dao = mock(AccountDao.class);
			account = new Account("testUser002", "pwd234");
			when(sut.dao.findOrNull("testUser002")).thenReturn(account);
		}

		@Test
		public void authenticationはaccountを返す() throws Exception {
			assertThat(sut.authenticate("testUser002", "pwd234"),is(sameInstance(account)));
		}
	}

	public static class アカウントが存在するがパスワードが一致しない場合 {
		Authentication sut;
		Account account;

		@Before
		public void setUp() {
			sut = new Authentication();
			sut.dao = mock(AccountDao.class);
			account = new Account("testUser003", "pwd345");
			when(sut.dao.findOrNull("testUser003")).thenReturn(account);
		}

		@Test
		public void authenticationはnullを返す() throws Exception {
			assertThat(sut.authenticate("testUser003", "pwd234"),is(nullValue()));
		}
	}

}
