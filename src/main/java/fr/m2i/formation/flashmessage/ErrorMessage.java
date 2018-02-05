package fr.m2i.formation.flashmessage;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.servlet.http.HttpSession;

public final class ErrorMessage {

    public static void createErrorMessage(HttpSession session, String messageKey) {
		List<String> errors = new ArrayList<>();
		if(session.getAttribute("errors") != null)
		{
			errors = (List<String>)session.getAttribute("errors");
			errors.add(messageKey);
			session.setAttribute("errors", errors);
		}
		else {
			errors.add(messageKey);
			session.setAttribute("errors", errors);
		}
    }
 
}
