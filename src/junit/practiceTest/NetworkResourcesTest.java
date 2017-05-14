package junit.practiceTest;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.ByteArrayInputStream;

import junit.practice.NetworkLoader;
import junit.practice.NetworkResources;

import org.junit.Test;

public class NetworkResourcesTest {

	@Test
	public void loadでネットワークから取得した文字列を返す() throws Exception {
		// SetUp
		String expected = "Hello World";
		NetworkLoader mockLoader = mock(NetworkLoader.class);
		ByteArrayInputStream input = new ByteArrayInputStream(expected.getBytes());
		when(mockLoader.getInput()).thenReturn(input);
		NetworkResources sut = new NetworkResources();
		sut.loader = mockLoader;

		// Excercixe
		String actual = sut.load();

		// Assertion
		assertThat(actual, is(expected));
	}

}
