package rs.iktpreobuka.project.skolski_dnevnik.utils;
import com.fasterxml.jackson.annotation.JsonView;


public class RestError {
	
	private String message;

	public RestError(String message) {
		super();
		this.message = message;
	}
	@JsonView(Views.Student.class)
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	

}
