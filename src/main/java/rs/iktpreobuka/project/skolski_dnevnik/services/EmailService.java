package rs.iktpreobuka.project.skolski_dnevnik.services;

import rs.iktpreobuka.project.skolski_dnevnik.models.EmailObject;

public interface EmailService {
	void sendSimpleMassage(EmailObject object);
	void sendTemplateMessage(EmailObject object) throws Exception;
	void sendMessageWithAttachment(EmailObject object, String pathToAttachment)throws Exception;
	
}
