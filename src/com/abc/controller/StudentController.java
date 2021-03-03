package com.abc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.abc.factory.StudentServiceFactory;
import com.abc.model.Student;
import com.abc.service.StudentService;

@WebServlet("/save")
public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String sid = request.getParameter("sid");
		String sname = request.getParameter("sname");
		String saddress = request.getParameter("saddress");

		Student student = new Student();
		student.setSid(sid);
		student.setSname(sname);
		student.setSaddr(saddress);

		StudentService studentService = StudentServiceFactory.getStudentService();
		String status = studentService.save(student);

		RequestDispatcher requestDispatcher = null;

		if (status.equalsIgnoreCase("success")) {
			// pass it to success.html
			requestDispatcher = request.getRequestDispatcher("success.html");
			requestDispatcher.forward(request, response);

		} else if (status.equalsIgnoreCase("failure")) {
			// pass it to failure.html
			requestDispatcher = request.getRequestDispatcher("failure.html");
			requestDispatcher.forward(request, response);

		} else {
			// pass it to alreadyexisted.html
			requestDispatcher = request.getRequestDispatcher("alreadyExisted.html");
			requestDispatcher.forward(request, response);

		}

	}

}
