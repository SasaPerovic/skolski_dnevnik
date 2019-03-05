package rs.iktpreobuka.project.skolski_dnevnik.entitiesDTO;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;

import rs.iktpreobuka.project.skolski_dnevnik.entities.ClassEntity;
import rs.iktpreobuka.project.skolski_dnevnik.entities.ParentEntity;
import rs.iktpreobuka.project.skolski_dnevnik.entities.ParsonEntity;
import rs.iktpreobuka.project.skolski_dnevnik.entities.RatingEntity;
import rs.iktpreobuka.project.skolski_dnevnik.entities.RoleEntety;
import rs.iktpreobuka.project.skolski_dnevnik.entities.StudentEntity;
import rs.iktpreobuka.project.skolski_dnevnik.entities.UserEntity;
import rs.iktpreobuka.project.skolski_dnevnik.utils.Views;



public class StudentEntityDTO{
	
	private Integer id;
	private String code;
	private ParentEntity parent;
	private ClassEntity clases;
	private ParsonEntity parson;
	private RoleEntety role;
	private UserEntity user;
	
	@JsonBackReference
	private List<RatingEntity> rating = new ArrayList<>();
	
	@JsonManagedReference
	@JsonView(Views.Student.class)
	@NotNull
	public ParentEntity getParent() {
		return parent;
	}
	public void setParent(ParentEntity parent) {
		this.parent = parent;
	}
	@JsonManagedReference
	@JsonView(Views.Student.class)
	@NotNull(message = "Class be provided.")
	public ClassEntity getClases() {
		return clases;
	}
	public List<RatingEntity> getRating() {
		return rating;
	}
	public void setRating(List<RatingEntity> rating) {
		this.rating = rating;
	}
	public void setClases(ClassEntity clases) {
		this.clases = clases;
	}
	@JsonManagedReference
	@JsonView(Views.Student.class)
	@NotNull
	public ParsonEntity getParson() {
		return parson;
	}
	public void setParson(ParsonEntity parson) {
		this.parson = parson;
	}
	@JsonManagedReference
	@JsonView(Views.Student.class)
	@NotNull
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
	@JsonProperty("ID")
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@JsonView(Views.Student.class)
	@NotNull
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	
	public StudentEntityDTO(Integer id, String code, ParentEntity parent, ClassEntity clases, ParsonEntity parson,
			RoleEntety role, UserEntity user, List<RatingEntity> rating) {
		super();
		this.id = id;
		this.code = code;
		this.parent = parent;
		this.clases = clases;
		this.parson = parson;
		this.role = role;
		this.user = user;
		this.rating = rating;
	}
	public StudentEntityDTO(StudentEntity student){
		this.id = student.getId();
		this.code = student.getCode();
		this.parent = student.getParent();
		this.clases = student.getClases();
		this.parson = student.getParson();
		this.role = student.getRole();
		this.user = student.getUser();
		this.rating = student.getRating();
	}
	public StudentEntityDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
}
