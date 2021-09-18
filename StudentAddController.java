package com.app;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.bean.StudentBean;
import com.app.service.StudentService;

public class StudentAddController extends HttpServlet {
//	private static Logger _log = LogManager.getLogManager().getLogger(StudentAddController.class.getName());

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

//		_log.log(Level.INFO, "StudentAddController.doPost() is call...");

		String bdate = req.getParameter("bdate");
		SimpleDateFormat dateF = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = dateF.parse(bdate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		StudentBean student = new StudentBean(0, req.getParameter("firstname"), req.getParameter("lastname"),
				date.getTime(), req.getParameter("email"), Long.valueOf(req.getParameter("phone")),
				Integer.valueOf(req.getParameter("gender")), req.getParameter("addressLine1"),
				req.getParameter("addressLine2"), req.getParameter("city"), req.getParameter("country"),
				req.getParameter("course"));

		StudentService service = new StudentService();
		
		boolean result = service.addStudent(student);
		if (result) {
			RequestDispatcher rd = req.getRequestDispatcher("/student-list");
			rd.forward(req, res);
		} else {
			req.setAttribute("errormessage", "Unable to do procedure.");
			RequestDispatcher rd = req.getRequestDispatcher("common/error.jsp");
			rd.forward(req, res);
		}

//		_log.log(Level.INFO, "StudentAddController.doPost() is finished...");
	}

}
