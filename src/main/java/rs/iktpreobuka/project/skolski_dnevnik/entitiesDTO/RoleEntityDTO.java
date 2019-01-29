package rs.iktpreobuka.project.skolski_dnevnik.entitiesDTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;

import rs.iktpreobuka.project.skolski_dnevnik.utils.Views;

public class RoleEntityDTO {
	
	private Integer id;
	private String teacher;
	private String admin;
	private String parent;
	private String student;
	
	@JsonProperty("ID")
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@JsonView(Views.Admin.class)
	public String getTeacher() {
		return teacher;
	}
	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}
	@JsonView(Views.Admin.class)
	public String getAdmin() {
		return admin;
	}
	public void setAdmin(String admin) {
		this.admin = admin;
	}
	@JsonView(Views.Admin.class)
	public String getParent() {
		return parent;
	}
	public void setParent(String parent) {
		this.parent = parent;
	}
	@JsonView(Views.Admin.class)
	public String getStudent() {
		return student;
	}
	public void setStudent(String student) {
		this.student = student;
	}
	public RoleEntityDTO(Integer id, String teacher, String admin, String parent, String student) {
		super();
		this.id = id;
		this.teacher = teacher;
		this.admin = admin;
		this.parent = parent;
		this.student = student;
	}
	public RoleEntityDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
