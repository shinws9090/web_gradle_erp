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

@WebServlet("/EmployeeInsertServlet")
public class EmployeeInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmployeeService service;
       
    public EmployeeInsertServlet() {
    	service = new EmployeeService();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
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
		
		
		Employee emp = new Employee(empno, empname, title, manager, salary, dept, hireDate);
		service.addEmployee(emp);
		
		request.getRequestDispatcher("EmployeeServlet").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
