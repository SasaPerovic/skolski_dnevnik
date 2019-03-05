package rs.iktpreobuka.project.skolski_dnevnik.entitiesDTO;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;

import rs.iktpreobuka.project.skolski_dnevnik.entities.AdminEntity;
import rs.iktpreobuka.project.skolski_dnevnik.entities.ParentEntity;
import rs.iktpreobuka.project.skolski_dnevnik.entities.ParsonEntity;
import rs.iktpreobuka.project.skolski_dnevnik.entities.StudentEntity;
import rs.iktpreobuka.project.skolski_dnevnik.entities.TeacherEntity;
import rs.iktpreobuka.project.skolski_dnevnik.entities.UserEntity;
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
	@JsonBackReference
	private List<AdminEntity>  admin = new ArrayList<>();
	@JsonBackReference
	private List<ParsonEntity> parson = new ArrayList<>();
	@JsonBackReference
	private List<StudentEntity> students = new ArrayList<>();
	@JsonBackReference
	private List<ParentEntity> parents = new ArrayList<>();
	@JsonBackReference
	private List<TeacherEntity> teachers = new ArrayList<>();
	
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
	
	public UserEntityDTO(UserEntity user) {
		this.id= user.getId();
		this.username = user.getUsername();
	}
	

	
}
