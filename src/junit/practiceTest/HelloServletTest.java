package junit.practiceTest;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import junit.practice.HelloServlet;
import junit.practice.StringServletOutputStream;

import org.junit.Test;

public class HelloServletTest {

	@Test
	public void doGetでリクエストパラメータを含むテキストを出力する() throws Exception {
		//SetUp
		HelloServlet sut = new HelloServlet();
		HttpServletRequest request = mock(HttpServletRequest.class);
		when(request.getParameter("name")).thenReturn("JUnit");
		ServletOutputStream output = mock(ServletOutputStream.class);
		HttpServletResponse response = mock(HttpServletResponse.class);
		when(response.getOutputStream()).thenReturn(output);

		//Exercise
		sut.doGet(request, response);

		//Verify
		verify(output).println("Hello JUnit");
		verify(response).setContentType("text/plain; charset=UTF-8");
		verify(response).flushBuffer();
	}

	@Test
	public void doGetでリクエストパラメータを含むテキストを出力する2() throws Exception {
		//SetUp
		HelloServlet sut = new HelloServlet();
		HttpServletRequest request = mock(HttpServletRequest.class);
		when(request.getParameter("name")).thenReturn("JUnit");
		StringServletOutputStream output = new StringServletOutputStream();
		HttpServletResponse response = mock(HttpServletResponse.class);
		when(response.getOutputStream()).thenReturn(output);

		//Exercise
		sut.doGet(request, response);

		//Verify
		assertThat(output.getOutput(), is("Hello JUnit\r\n"));
		verify(response).setContentType("text/plain; charset=UTF-8");
		verify(response).flushBuffer();
	}

}