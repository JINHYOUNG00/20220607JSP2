package co.jin.prj.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.jin.prj.student.service.StudentService;
import co.jin.prj.student.serviceImpl.StudentServiceImpl;
import co.jin.prj.student.vo.StudentVO;

public class MemberListCommand implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// DB처리하는 부분 작업하고
		// 보여줄 페이지에 값을 가지고
		
		StudentService dao = new StudentServiceImpl();
		List<StudentVO> students = new ArrayList<StudentVO>();
		request.setAttribute("student", students);
		return "member/member";
	}

}
