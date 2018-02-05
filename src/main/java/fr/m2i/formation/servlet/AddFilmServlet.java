package fr.m2i.formation.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.m2i.formation.bean.Acteur;
import fr.m2i.formation.bean.Film;
import fr.m2i.formation.bean.Realisateur;
import fr.m2i.formation.bean.Style;
import fr.m2i.formation.dao.FilmDao;
import fr.m2i.formation.dao.StyleDao;
import fr.m2i.formation.flashmessage.ErrorMessage;
import fr.m2i.formation.flashmessage.SuccessMessage;

/**
 * Servlet implementation class AddFilmServlet
 */
public class AddFilmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StyleDao sdao = new StyleDao();
		List<Style> styles = sdao.getAllStyle();
		request.setAttribute("styles", styles);
		RequestDispatcher rd = request.getRequestDispatcher("addfilm.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		Film film = new Film();
		StyleDao sdao = new StyleDao();
		FilmDao fdao = new FilmDao();
		List<Style> styles = sdao.getAllStyle();
		request.setAttribute("styles", styles);
		List<Acteur> acteurListe = new ArrayList<>();
		for(String str : request.getParameterValues("acteur")) {
			if(!str.isEmpty()) {
				acteurListe.add(new Acteur(str));
			}
		}
		int styleId = Integer.parseInt(request.getParameter("style"));
		film.setActeurs(acteurListe);
		film.setStyle(sdao.getStyle(styleId));
		film.setTitre(request.getParameter("titre"));
		film.setAnnee(request.getParameter("annee"));
		film.setSynopsis(request.getParameter("synopsis"));
		film.setRealisateur(new Realisateur(request.getParameter("realisateur")));
		film.setVu(request.getParameter("vu"));
		film.setDuree(request.getParameter("duree"));
		try {
			fdao.addFilm(film);
			SuccessMessage.createSuccessMessage(session, "Le film a bien été ajouté");
		} catch (Exception e) {
			ErrorMessage.createErrorMessage(session, e.getMessage());
		}
		response.sendRedirect("films");
	}

}
