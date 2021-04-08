package web_gradle_erp.dao;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import web_gradle_erp.JdbcUtil;
import web_gradle_erp.dao.impl.TitleDaoImpl;
import web_gradle_erp.dto.Title;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TitleDaoTest {
	private static Connection con;
	private static TitleDaoImpl dao = TitleDaoImpl.getInstance();

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
	public void test01SelectTitleByAll() {
		System.out.println("test01SelectTitleByAll");
		List<Title> list = dao.selectTitleByAll();

		Assert.assertNotNull(list);

		list.stream().forEach(System.out::println);
	}

	@Test
	public void test02SelectTitleByNo() {
		System.out.println("test02SelectTitleByNo");

		Title title = dao.selectTitleByNo(new Title(1));

		Assert.assertNotNull(title);
		System.out.println(title);
	}

	@Test
	public void test03InsertTitle() {
		System.out.println("test03InsertTitle");

		int res = dao.insertTitle(new Title(6, "인턴"));

		Assert.assertEquals(res, 1);
		System.out.println(dao.selectTitleByNo(new Title(6)));
	}

	@Test
	public void test04UpdateTitle() {
		System.out.println("test04UpdateTitle");

		int res = dao.updateTitle(new Title(6, "인턴턴"));

		Assert.assertEquals(res, 1);
		System.out.println(dao.selectTitleByNo(new Title(6)));
	}

	@Test
	public void test05DeleteTitle() {
		System.out.println("test05DeleteTitle");

		int res = dao.deleteTitle(new Title(6));

		Assert.assertEquals(res, 1);
	}

}
