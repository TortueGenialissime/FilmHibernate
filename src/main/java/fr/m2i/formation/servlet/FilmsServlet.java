package fr.m2i.formation.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.m2i.formation.bean.Film;
import fr.m2i.formation.dao.FilmDao;

/**
 * Servlet implementation class FilmsServlet
 */
public class FilmsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FilmDao fdao = new FilmDao();
		List<Film> films = fdao.getAllFilms();
		request.setAttribute("films", films);
		RequestDispatcher rd = request.getRequestDispatcher("films.jsp");
		rd.forward(request, response);
	}
}
