package rs.iktpreobuka.project.skolski_dnevnik.entitiesDTO;

import java.time.LocalDate;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;
import rs.iktpreobuka.project.skolski_dnevnik.entities.enums.Role;
import rs.iktpreobuka.project.skolski_dnevnik.utils.Views;

public class ParsonEntityDTO{
	
	
	private Integer id;
	private String name;
	private String lastname;
	private String email;
	private LocalDate dayOfBrth;
	private String phoneNumber;
	private Role role;
	

	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	@JsonProperty("ID")
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@JsonView(Views.Student.class)
	@NotNull(message = "First name must be provided.")
	@Size(min=2, max=30, message = "First name must be between {min} and {max} characters long.")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@JsonView(Views.Student.class)
	@NotNull(message = "Last name must be provided.")
	@Size(min=2, max=30, message = "Last name must be between {min} and {max} characters long.")
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	@JsonView(Views.Admin.class)
	@NotNull(message = "Email must be provided.")
	@Pattern(regexp = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$", message="Email is not valid.")
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@JsonView(Views.Admin.class)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	public LocalDate getDayOfBrth() {
		return dayOfBrth;
	}
	public void setDayOfBrth(LocalDate dayOfBrth) {
		this.dayOfBrth = dayOfBrth;
	}
	@JsonView(Views.Admin.class)
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public ParsonEntityDTO(Integer id, String name, String lastname, String email, LocalDate dayOfBrth,
			String phoneNumber, Role role) {
		super();
		this.id = id;
		this.name = name;
		this.lastname = lastname;
		this.email = email;
		this.dayOfBrth = dayOfBrth;
		this.phoneNumber = phoneNumber;
		this.role = role;
		
	}
	public ParsonEntityDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
