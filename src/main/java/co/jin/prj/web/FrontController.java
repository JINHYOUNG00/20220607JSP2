package co.jin.prj.web;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 모든 요청을 받아서 처리하는 곳
 */
@WebServlet("*.do") // 모든요청을 받는다. /*만 써도 되지만 관례적으로 .do도 붙임.
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HashMap<String, Command> map = new HashMap<String, Command>();

	public FrontController() {
		super();
	}

	/**
	 * 요청과 처리 명령어를 연결하는 부분
	 */
	public void init(ServletConfig config) throws ServletException {
		
		// Command 인터페이스에 구현객체가 추가될때마다 하나하나 맵에 넣어줘야함.
		map.put("/test.do", new TestCommand());   // /test.do 를 넣어주면 TestCommand가 리턴됨
		map.put("/memberList.do", new MemberListCommand()); // 학생목록

	}

	/**
	 * 여기서 들어온 요청을 분석하고 명령을 실행해서 결과를 돌려보내주는 곳
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); // 한글깨짐방지
//		response.setCharacterEncoding("utf-8");
		String uri = request.getRequestURI(); // uri에 요청한 페이지의 URI만 담음.
		String contextPath = request.getContextPath(); // contextPath에 페이지의 컨택스트패스를 담음. // 루트 디렉토리 정보
		String page = uri.substring(contextPath.length()); // 실제 요청 명령을 받음

		Command command = map.get(page); // 실행할 명령객체를 찾음
		String viewPage = command.exec(request, response); // 명령을 실행하고 결과를 돌려받음. // 보여줄 페이지를 담음.

		if (!viewPage.endsWith(".do") && !viewPage.equals(null)) {       // viewResolve
			viewPage ="/WEB-INF/jsp/" + viewPage + ".jsp";
		}
		
		// 결과 페이지를 돌려준다.
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response); // 보여줄 페이지를 던져줌
		
	}

}
