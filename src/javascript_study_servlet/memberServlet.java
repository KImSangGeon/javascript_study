package javascript_study_servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member_login")
public class memberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	private void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws UnsupportedEncodingException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String userId = request.getParameter("user_id");
		String userPwd = request.getParameter("user_pw");
		
		System.out.printf("userId : %s userPwd : %s ", userId, userPwd);
		
		String name = null;
		if(userId.equals("korean") && userPwd.equals("12345")){
			name = "박부장";
		}else if(userId.equals("seoul") && userPwd.equals("56789")){
			name = "홍대리";
		}
		System.out.println();
		PrintWriter out = response.getWriter();
		out.print(String.format("{\"user_id\" :\"%s\", \"user_name\" : \"%s\" }", userId, name));
		System.out.println();
		System.out.printf(String.format("{\"user_id\" :\"%s\", \"user_name\" : \"%s\"}", userId, name));
	}
}
