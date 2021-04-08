package web_gradle_erp.service;

import java.sql.Connection;
import java.util.List;

import web_gradle_erp.dao.impl.TitleDaoImpl;
import web_gradle_erp.ds.JndiDS;
import web_gradle_erp.dto.Title;

public class TitleService {
	private Connection con = JndiDS.getConnection();
	private TitleDaoImpl dao = TitleDaoImpl.getInstance();
	
	public TitleService() {
		dao.setCon(con);
	}
	
	public List<Title> showTitles(){
		return dao.selectTitleByAll();
	}
	public void addTitle(Title title){
		dao.insertTitle(title);
	}
	public void modifyTitle(Title title){
		dao.updateTitle(title);
	}
	public void removeTitle(Title title){
		dao.deleteTitle(title);
	}
	
	public Title showTitle(Title title){
		return dao.selectTitleByNo(title);
	}
	
	
	
}
