package rs.iktpreobuka.project.skolski_dnevnik.entitiesDTO;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;

import rs.iktpreobuka.project.skolski_dnevnik.entities.ParentEntity;
import rs.iktpreobuka.project.skolski_dnevnik.entities.ParsonEntity;
import rs.iktpreobuka.project.skolski_dnevnik.entities.RoleEntety;
import rs.iktpreobuka.project.skolski_dnevnik.entities.StudentEntity;
import rs.iktpreobuka.project.skolski_dnevnik.entities.UserEntity;
import rs.iktpreobuka.project.skolski_dnevnik.utils.Views;

public class ParentEntityDTO {

	
	private Integer id;
	private Integer numbOfStu;
	private ParsonEntity parson;
	private RoleEntety role;
	private UserEntity user;
	
	
	@JsonBackReference
	private List<StudentEntity> student= new ArrayList<>();
	
	@JsonManagedReference
	@JsonView(Views.Student.class)
	public RoleEntety getRole() {
		return role;
	}
	public void setRole(RoleEntety role) {
		this.role = role;
	}
	@JsonManagedReference
	@JsonView(Views.Student.class)
	public UserEntity getUser() {
		return user;
	}
	public void setUser(UserEntity user) {
		this.user = user;
	}
	@JsonManagedReference
	@JsonView(Views.Student.class)
	public List<StudentEntity> getStudent() {
		return student;
	}
	public void setStudent(List<StudentEntity> student) {
		this.student = student;
	}
	@JsonManagedReference
	@JsonView(Views.Student.class)
	public ParsonEntity getParson() {
		return parson;
	}
	public void setParson(ParsonEntity parson) {
		this.parson = parson;
	}
	@JsonProperty("ID")
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@JsonView(Views.Parent.class)
	public Integer getNumbOfStu() {
		return numbOfStu;
	}
	public void setNumbOfStu(Integer numbOfStu) {
		this.numbOfStu = numbOfStu;
	}
	
	public ParentEntityDTO(Integer id, Integer numbOfStu, ParsonEntity parson, RoleEntety role, UserEntity user,
			List<StudentEntity> student) {
		super();
		this.id = id;
		this.numbOfStu = numbOfStu;
		this.parson = parson;
		this.role = role;
		this.user = user;
		this.student = student;
	}
	public ParentEntityDTO(ParentEntity parent) {

		this.id = parent.getId();
		this.numbOfStu = parent.getNumbOfStu();
		this.parson = parent.getParson();
		this.role = parent.getRole();
		this.user = parent.getUser();
		this.student = parent.getStudent();
	}
	public ParentEntityDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
