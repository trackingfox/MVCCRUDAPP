package com.abc.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.abc.factory.StudentServiceFactory;
import com.abc.model.Student;
import com.abc.service.StudentService;

@WebServlet("/display")
public class DisplayController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<h1 style='color:red;text-align:center;'>Aradhya Brilliance center</h1>");
		out.println("<h1 style='color:blue;text-align:center;'>Student Updation form</h1>");

		String sid = request.getParameter("sid");

		StudentService studentService = StudentServiceFactory.getStudentService();
		Student student = studentService.displayStudent(sid);
		if (student != null) {

			out.println("<form method='get' action='./update'>");
			out.println("<table align='center' bgcolor='cyan'>");

			out.println("<tr>");

			out.println("<td>SID</td>");
			out.println("<td>");
			out.println(student.getSid());
			out.println("<td> <input type='hidden' name='sid' value='" + student.getSid() + "'/></td>");
			out.println("</td><br/>");
			
			out.println("</tr>");

			out.println("<tr>");

			out.println("<td>SNAME</td>");
			out.println("<td>");
			out.println("<input type='text' name='sname' value='" + student.getSname() + "'/>");
			out.println("</td><br/>");
			out.println("</tr>");

			out.println("<tr>");

			out.println("<td>SADDR</td>");
			out.println("<td>");
			out.println("<input type='text' name='saddr' value='" + student.getSaddr() + "'/>");
			out.println("</td><br/>");
			out.println("</tr>");

			out.println("<tr>");

			out.println("<td></td>");
			out.println("<td>");
			out.println("<input type='submit' value='updateByID'/>");
			out.println("</td>");

			out.println("</tr>");

			out.println("</table>");
			out.println("</form>");

		} else {
			out.println("<h3 style='color:red; text-align:center;'>Student record not found for updation</h3>");
		}

		out.println("</body></html>");

	}

}
