package web_gradle_erp.dao.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web_gradle_erp.dto.Department;
import web_gradle_erp.dto.Employee;
import web_gradle_erp.dto.Title;
import web_gradle_erp.service.DepartmentService;
import web_gradle_erp.service.EmployeeService;
import web_gradle_erp.service.TitleService;

@WebServlet("/EmployeeGetServlet")
public class EmployeeGetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmployeeService service;
	private TitleService titleService;
	private DepartmentService deptservice;

	public EmployeeGetServlet() {
		service = new EmployeeService();
		titleService = new TitleService();
		deptservice = new DepartmentService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");

		int empNo = Integer.parseInt(request.getParameter("empNo").trim());
		Employee employee = service.showEmployee(new Employee(empNo));
		request.setAttribute("Employee", employee);
		List<Title> titleList = titleService.showTitles();
		List<Department> deptList = deptservice.showDepartments();
		List<Employee> managerList = service.showEmployees();
		request.setAttribute("titleList", titleList);
		request.setAttribute("deptList", deptList);
		request.setAttribute("managerList", managerList);

//		request.getRequestDispatcher("employeeInfo.jsp").forward(request, response);
		request.setAttribute("page", "employeeInfo.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
