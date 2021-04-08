package web_gradle_erp.dao.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web_gradle_erp.dto.Department;
import web_gradle_erp.service.DepartmentService;

@WebServlet("/DepartmentInsertServlet")
public class DepartmentInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private DepartmentService service;
    
    public DepartmentInsertServlet() {
    	service = new DepartmentService();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int deptno = Integer.parseInt(request.getParameter("deptno"));
		String deptname = request.getParameter("deptname");
		Department department = new Department(deptno,deptname);
		service.addDepartment(department);
		
//		request.getRequestDispatcher("DepartmentServlet").forward(request, response);
		response.sendRedirect("DepartmentServlet");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
