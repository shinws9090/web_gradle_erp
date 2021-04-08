package web_gradle_erp.service;

import java.sql.Connection;
import java.util.List;

import web_gradle_erp.dao.impl.DepartmentDaoImpl;
import web_gradle_erp.ds.JndiDS;
import web_gradle_erp.dto.Department;

public class DepartmentService {
	private Connection con = JndiDS.getConnection();
	private DepartmentDaoImpl dao = DepartmentDaoImpl.getInstance();
	
	public DepartmentService() {
		dao.setCon(con);
	}
	
	public List<Department> showDepartments(){
		return dao.selectDepartmentByAll();
	}
	public Department showDepartment(Department department){
		return dao.selectDepartmentByNo(department);
	}
	public void addDepartment(Department department) {
		dao.insertDepartment(department);
	}
	public void modifyDepartment(Department department) {
		dao.updateDepartment(department);
	}
	public void removeDepartment(Department department) {
		dao.deleteDepartment(department);
	}
	
	
}
