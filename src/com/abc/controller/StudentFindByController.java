package com.abc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.abc.factory.StudentServiceFactory;
import com.abc.model.Student;
import com.abc.service.StudentService;

@WebServlet("/find")
public class StudentFindByController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

		String sid = request.getParameter("sid");

		StudentService studentService = StudentServiceFactory.getStudentService();
		List<Student> student = studentService.findById(sid);

		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<h1 style='color:red; text-align:center;'>Aradhya Brilliance Center</h1>");
		out.println("<h2 style='color:blue; text-align:center;'>Student Details</h2>");
		if (student != null) {
			out.println("<table width=60% cellpadding=3 border='1' align='center' bgcolor='cyan'>");

			out.println("<tr><td>SID</td><td>SNAME</td><td>SADDR</td></tr>");
			for (Student std : student) {
				out.println("<tr>");
				out.println("<td>" + std.getSid() + "</td>");
				out.println("<td>" + std.getSname() + "</td>");
				out.println("<td>" + std.getSaddr() + "</td>");

				out.println("</tr>");

			}
			out.println("</table>");

		} else {
			out.println(
					"<h1 style='color:red; text-align:center;'>Record not found for the given id ::" + sid + "</h1>");
		}
		out.println("</body></html>");
		out.close();

	}

}
