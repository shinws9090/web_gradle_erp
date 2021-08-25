package web_gradle_erp.dao.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web_gradle_erp.dto.Department;
import web_gradle_erp.dto.Employee;
import web_gradle_erp.dto.Title;
import web_gradle_erp.service.EmployeeService;

@WebServlet("/EmployeeUpdateServlet")
public class EmployeeUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private EmployeeService service;
    
    public EmployeeUpdateServlet() {
    	service = new EmployeeService();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		service.modifyEmployee(getEmployee(request,response));
//		request.getRequestDispatcher("TitleServlet").forward(request, response);
		response.sendRedirect("EmployeeServlet");
		
	}

	private Employee getEmployee(HttpServletRequest request, HttpServletResponse response) {
		
		int empno = Integer.parseInt(request.getParameter("empno"));
		String empname = request.getParameter("empname");
		Title title = new Title(Integer.parseInt(request.getParameter("title")));
		Employee manager = new Employee(Integer.parseInt(request.getParameter("manager")));
		int salary = Integer.parseInt(request.getParameter("salary"));
		Department dept = new Department(Integer.parseInt(request.getParameter("dept")));
		
		SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date hireDate = null;
		try {
			hireDate = transFormat.parse(request.getParameter("hireDate"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return new Employee(empno, empname, title, manager, salary, dept, hireDate);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
