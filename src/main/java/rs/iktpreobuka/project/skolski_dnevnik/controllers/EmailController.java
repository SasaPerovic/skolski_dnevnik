package rs.iktpreobuka.project.skolski_dnevnik.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import rs.iktpreobuka.project.skolski_dnevnik.models.EmailObject;
import rs.iktpreobuka.project.skolski_dnevnik.services.EmailService;


@RestController
@RequestMapping(path = "/api/v1/email")
public class EmailController {
	@Autowired
	private EmailService emailService;
	
	
	@RequestMapping(method = RequestMethod.POST, value = "/simpleEmail")
		public String sendSimpleMessage(@RequestBody EmailObject object) {
			if(object==null || object.getTo()==null ||
					object.getText()==null) {
				return null;
			}
			emailService.sendSimpleMassage(object);
			return "Your mail has been sent!";
		}

	@RequestMapping(method = RequestMethod.POST, value = "/templateEmail")
	public String sendTemplateMessage(@RequestBody EmailObject object) throws Exception {

		if (object == null || object.getTo() == null || object.getText() == null) {
			return null;
		}
		emailService.sendTemplateMessage(object);
		return "Your mail has been sent!";
	}
}
