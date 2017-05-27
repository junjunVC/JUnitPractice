package junit.practice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.*;

public class HelloServlet extends HttpServlet {
	private static final long serialVersionID = 1L;

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		resp.getOutputStream().println("Hello " + name);
		resp.setContentType("text/plain; charset=UTF-8");
		resp.flushBuffer();
	}
}