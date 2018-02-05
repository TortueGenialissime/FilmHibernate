package fr.m2i.formation.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.m2i.formation.dao.StyleDao;
import fr.m2i.formation.flashmessage.ErrorMessage;
import fr.m2i.formation.flashmessage.SuccessMessage;

/**
 * Servlet implementation class AddStyleServlet
 */
public class AddStyleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true); 
		if(request.getParameter("libelle") != null || request.getParameter("libelle").length() == 0 ) {
			StyleDao sdao = new StyleDao();
			try {
				sdao.addStyle(request.getParameter("libelle"));
				SuccessMessage.createSuccessMessage(session, "Le style a bien été ajouté");
			} catch (Exception e) {
				ErrorMessage.createErrorMessage(session, e.getMessage());
			}
		}
		else {
			ErrorMessage.createErrorMessage(session, "Libellé vide");
		}
		response.sendRedirect("style");
	}
}
