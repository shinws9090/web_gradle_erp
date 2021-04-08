package web_gradle_erp.dao.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web_gradle_erp.dto.Department;
import web_gradle_erp.service.DepartmentService;

@WebServlet("/DepartmentGetServlet")
public class DepartmentGetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DepartmentService service;
	
    public DepartmentGetServlet() {
    	service = new DepartmentService();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		int deptno = Integer.parseInt(request.getParameter("deptNo").trim());
		Department department = service.showDepartment(new Department(deptno));
		request.setAttribute("Department", department);
		
//		request.getRequestDispatcher("departmaentInfo.jsp").forward(request, response);
		request.setAttribute("page", "departmaentInfo.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
