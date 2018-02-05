package fr.m2i.formation.flashmessage;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.servlet.http.HttpSession;

public final class SuccessMessage {

    public static void createSuccessMessage(HttpSession session, String messageKey) {
		List<String> errors = new ArrayList<>();
		if(session.getAttribute("success") != null)
		{
			errors = (List<String>)session.getAttribute("success");
			errors.add(messageKey);
			session.setAttribute("success", errors);
		}
		else {
			errors.add(messageKey);
			session.setAttribute("success", errors);
		}
    }
 
}
