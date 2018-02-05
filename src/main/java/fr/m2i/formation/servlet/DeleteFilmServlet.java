package fr.m2i.formation.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.m2i.formation.dao.FilmDao;
import fr.m2i.formation.dao.StyleDao;
import fr.m2i.formation.flashmessage.ErrorMessage;
import fr.m2i.formation.flashmessage.SuccessMessage;

/**
 * Servlet implementation class DeleteFilmServlet
 */
public class DeleteFilmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true); 
		if(request.getParameter("id") != null || request.getParameter("id").length() == 0 ) {
			FilmDao pdao = new FilmDao();
			try {
				pdao.deleteFilm(Integer.parseInt(request.getParameter("id")));
				SuccessMessage.createSuccessMessage(session, "Le film a bien été supprimé");
			} catch (Exception e) {
				ErrorMessage.createErrorMessage(session, e.getMessage());
			}
		}
		else {
			ErrorMessage.createErrorMessage(session, "Impossible de supprimer");
		}
		response.sendRedirect("films");

	}

}
