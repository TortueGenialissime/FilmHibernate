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

import org.hibernate.Session;
import org.jsoup.Connection.Request;

import fr.m2i.formation.dao.StyleDao;
import fr.m2i.formation.flashmessage.ErrorMessage;
import fr.m2i.formation.flashmessage.SuccessMessage;

/**
 * Servlet implementation class AddStyleServlet
 */
public class DeleteStyleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true); 
		if(request.getParameter("id") != null || request.getParameter("id").length() == 0 ) {
			StyleDao sdao = new StyleDao();
			try {
				sdao.deleteStyle(Integer.parseInt(request.getParameter("id")));
				SuccessMessage.createSuccessMessage(session, "Le style à bien été supprimé");
			} catch (Exception e) {
				ErrorMessage.createErrorMessage(session, e.getMessage());
			}
		}
		else {
			ErrorMessage.createErrorMessage(session, "Impossible de supprimer");
		}
		RequestDispatcher rd = request.getRequestDispatcher("style");
		rd.forward(request, response);
	}

}
