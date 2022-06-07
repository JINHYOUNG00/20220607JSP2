package co.jin.prj.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestCommand implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// test.do 처리하는곳
		return "test1";
	}

}
