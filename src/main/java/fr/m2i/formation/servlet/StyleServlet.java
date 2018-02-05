package fr.m2i.formation.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.m2i.formation.bean.Style;
import fr.m2i.formation.dao.StyleDao;

/**
 * Servlet implementation class StyleServlet
 */
public class StyleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StyleDao sdao = new StyleDao();
		List<Style> styles = sdao.getAllStyle();
		request.setAttribute("styles", styles);
		RequestDispatcher rd = request.getRequestDispatcher("/style.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
