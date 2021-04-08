package web_gradle_erp.service;

import java.sql.Connection;
import java.util.List;

import web_gradle_erp.dao.impl.EmployeeDaoImpl;
import web_gradle_erp.ds.JndiDS;
import web_gradle_erp.dto.Employee;

public class EmployeeService {
	private Connection conn = JndiDS.getConnection();
	private EmployeeDaoImpl dao = EmployeeDaoImpl.getInstance();

	public EmployeeService() {
		dao.setCon(conn);
	}

	public List<Employee> showEmployees() {
		return dao.selectEmployeeByAll();
	}

	public Employee showEmployee(Employee emp) {
		return dao.selectEmployeeByNo(emp);
	}

	public void addEmployee(Employee emp) {
		dao.insertEmployee(emp);
	}

	public void deleteEmployee(Employee emp) {
		dao.deleteEmployee(emp);
	}

	public void modifyEmployee(Employee emp) {
		dao.updateEmployee(emp);
	}

}
