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
 * Servlet implementation class FilmServlet
 */
public class FilmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("id") != null && request.getParameter("id").length() > 0) {
			int filmId = Integer.parseInt(request.getParameter("id"));
			FilmDao fdao = new FilmDao();
			Film film = fdao.getFilm(filmId);
			request.setAttribute("film",film);
			RequestDispatcher rd = request.getRequestDispatcher("film.jsp");
			rd.forward(request, response);
		}
	}
}
