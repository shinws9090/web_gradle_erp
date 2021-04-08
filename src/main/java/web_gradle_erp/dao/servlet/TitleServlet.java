package web_gradle_erp.dao.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web_gradle_erp.dto.Title;
import web_gradle_erp.service.TitleService;

@WebServlet("/TitleServlet")
public class TitleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TitleService service;
       
	
	
	public TitleServlet() {
		service = new TitleService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		List<Title> list = service.showTitles();
//		list.stream().forEach(System.out::println);
		
		request.setAttribute("list", list);
		request.setAttribute("page", "titleList.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
//		request.getRequestDispatcher("titleList.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
