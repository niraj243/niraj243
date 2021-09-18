package com.app;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.bean.StudentBeanAddData;
import com.app.service.StudentService;

public class StudentRedirectDeleteController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		StudentService studService = new StudentService();
		boolean student = studService.deleteStudent(Long.valueOf(req.getParameter("studentId")));

		if (student==false) {
			RequestDispatcher rd = req.getRequestDispatcher("/student-list");
			rd.forward(req, resp);
		} else {
			req.setAttribute("errormessage", "Unable to add student details.");
			RequestDispatcher rd = req.getRequestDispatcher("common/error.jsp");
			rd.forward(req, resp);
		}
	}
}
