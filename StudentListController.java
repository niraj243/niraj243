package com.app;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.bean.StudentBean;
import com.app.service.StudentService;

public class StudentListController extends HttpServlet {
//	private static Logger _log = LogManager.getLogger(StudentListController.class.getName());

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		doPost(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
//		_log.info("StudentListController.doPost() is call...");
		StudentService studService = new StudentService();
		List<StudentBean> students = studService.getStudents();
		req.setAttribute("students", students);
		RequestDispatcher rd = req.getRequestDispatcher("student-list-view.jsp");
		rd.forward(req, res);
//		_log.info("StudentListController.doPost() is finished...");
	}
}
