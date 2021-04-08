package web_gradle_erp.dao.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web_gradle_erp.dto.Title;
import web_gradle_erp.service.TitleService;

@WebServlet("/TitleUpdateServlet")
public class TitleUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private TitleService service;
    
    public TitleUpdateServlet() {
    	service = new TitleService();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int tno = Integer.parseInt(request.getParameter("tno"));
		String tname = request.getParameter("tname");
		Title title = new Title(tno,tname);
		System.out.println(title);
		service.modifyTitle(title);
//		request.getRequestDispatcher("TitleServlet").forward(request, response);
		response.sendRedirect("TitleServlet");
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
