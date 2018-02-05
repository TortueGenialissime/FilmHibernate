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

import fr.m2i.formation.bean.Style;
import fr.m2i.formation.dao.StyleDao;
import fr.m2i.formation.flashmessage.ErrorMessage;
import fr.m2i.formation.flashmessage.SuccessMessage;

/**
 * Servlet implementation class AddStyleServlet
 */
public class UpdateStyleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true); 
		if(request.getParameter("id") != null && request.getParameter("libelle") != null) {
			StyleDao sdao = new StyleDao();
			try {
				Style s = sdao.getStyle(Integer.parseInt(request.getParameter("id")));
				s.setLibelle(request.getParameter("libelle"));
				sdao.updateStyle(s);
				SuccessMessage.createSuccessMessage(session, "Le style a bien été modifié");
			} catch (Exception e) {
				ErrorMessage.createErrorMessage(session, e.getMessage());
			}
		}
		else {
			ErrorMessage.createErrorMessage(session, "Impossible de modifier");
		}
		response.sendRedirect("style");
	}

}
