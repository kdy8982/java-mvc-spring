package whiteship;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet { // 이 서블릿 클래스를 사용하는 것을 정하는 부분은 web.xml

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		if(name == null) {
			name="JSP";
		}
		
		String hello = "hello " + name;
		
		req.setAttribute("hello", hello);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/Hello.jsp"); // 보여줄 view를 선택
		dispatcher.forward(req, resp);
	}
}
