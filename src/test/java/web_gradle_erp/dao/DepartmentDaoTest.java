package web_gradle_erp.dao;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import web_gradle_erp.JdbcUtil;
import web_gradle_erp.dao.impl.DepartmentDaoImpl;
import web_gradle_erp.dto.Department;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DepartmentDaoTest {
	private static Connection con;
	private static DepartmentDaoImpl dao = DepartmentDaoImpl.getInstance();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		con = JdbcUtil.getConnection();
		dao.setCon(con);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		con.close();

	}

	@After
	public void tearDown() throws Exception {
		System.out.println();
	}

	@Test
	public void test01SelectDepartmentByAll() {
		System.out.println("test01SelectDepartmentByAll");
		List<Department> list = dao.selectDepartmentByAll();

		Assert.assertNotNull(list);

		list.stream().forEach(System.out::println);
	}

	@Test
	public void test02SelectDepartmentByNo() {
		System.out.println("test02SelectDepartmentByNo");
		Department department = dao.selectDepartmentByNo(new Department(1));

		Assert.assertNotNull(department);
		System.out.println(department);
	}

	@Test
	public void test03InsertDepartment() {
		System.out.println("test03InsertDepartment");
		int res = dao.insertDepartment(new Department(99, "시발"));

		Assert.assertEquals(res, 1);
		System.out.println(dao.selectDepartmentByNo(new Department(99)));
	}

	@Test
	public void test04UpdateDepartment() {
		System.out.println("test04UpdateDepartment");
		int res = dao.updateDepartment(new Department(99, "쟞같네"));

		Assert.assertEquals(res, 1);
		System.out.println(dao.selectDepartmentByNo(new Department(99)));
	}

	@Test
	public void test05DeleteDepartment() {
		System.out.println("test05DeleteDepartment");
		int res = dao.deleteDepartment(new Department(99));

		Assert.assertEquals(res, 1);
	}

}
