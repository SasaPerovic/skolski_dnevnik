package rs.iktpreobuka.project.skolski_dnevnik.services;

import rs.iktpreobuka.project.skolski_dnevnik.models.EmailObject;

public interface EmailService {
	void sendSimpleMassage(EmailObject object);
}
