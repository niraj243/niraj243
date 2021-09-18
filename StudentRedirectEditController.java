package com.app;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.bean.StudentBean;
import com.app.bean.StudentBeanAddData;
import com.app.service.StudentService;

public class StudentRedirectEditController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		StudentService studService = new StudentService();
		StudentBeanAddData student = studService.getStudentByStudentId(Long.valueOf(req.getParameter("studentId")));
		req.setAttribute("student", student);
		RequestDispatcher rd = req.getRequestDispatcher("/student-edit-details.jsp");
		rd.forward(req, resp);
	}
}
