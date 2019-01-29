package rs.iktpreobuka.project.skolski_dnevnik.entitiesDTO;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;

import rs.iktpreobuka.project.skolski_dnevnik.utils.Views;

public class UserEntityDTO {
	
	
	private Integer id;
	private String username;
	private String password;
	
	@JsonProperty("ID")
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@JsonView(Views.Student.class)
	@JsonProperty("name")
	@NotNull(message = "Username must be provided.")
	@Size(min=5, max=15, message = "Username must be between {min} and {max} characters long.")
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	@JsonIgnore
	@NotNull(message = "Password must be provided.")
	@Size(min=5, max=10, message = "Password must be between {min} and {max} characters long.")
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public UserEntityDTO(Integer id, String username, String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	}
	public UserEntityDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

	
}
