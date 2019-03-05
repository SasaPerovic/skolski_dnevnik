package rs.iktpreobuka.project.skolski_dnevnik.entitiesDTO;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;

import rs.iktpreobuka.project.skolski_dnevnik.entities.ParsonEntity;
import rs.iktpreobuka.project.skolski_dnevnik.entities.RatingEntity;
import rs.iktpreobuka.project.skolski_dnevnik.entities.RoleEntety;
import rs.iktpreobuka.project.skolski_dnevnik.entities.TeachSubEntity;
import rs.iktpreobuka.project.skolski_dnevnik.entities.TeacherEntity;
import rs.iktpreobuka.project.skolski_dnevnik.entities.UserEntity;
import rs.iktpreobuka.project.skolski_dnevnik.utils.Views;

public class TeacherEntityDTO {
	
	
	private Integer id;
	private Integer code;
	private String titli;
	private ParsonEntity parson;
	private RoleEntety role;
	private UserEntity user;
	
	@JsonBackReference
	private List<TeachSubEntity> teachSub = new ArrayList<>();
	
	@JsonBackReference
	private List<RatingEntity> rating = new ArrayList<>();
	
	@JsonManagedReference
	@JsonView(Views.Student.class)
	public ParsonEntity getParson() {
		return parson;
	}
	public void setParson(ParsonEntity parson) {
		this.parson = parson;
	}
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
	public List<TeachSubEntity> getTeachSub() {
		return teachSub;
	}
	public void setTeachSub(List<TeachSubEntity> teachSub) {
		this.teachSub = teachSub;
	}
	@JsonProperty("ID")
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@JsonView(Views.Teacher.class)
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	@JsonView(Views.Admin.class)
	public String getTitli() {
		return titli;
	}
	public void setTitli(String titli) {
		this.titli = titli;
	}
	
	public TeacherEntityDTO(Integer id, Integer code, String titli, ParsonEntity parson, RoleEntety role,
			UserEntity user, List<TeachSubEntity> teachSub, List<RatingEntity> rating) {
		super();
		this.id = id;
		this.code = code;
		this.titli = titli;
		this.parson = parson;
		this.role = role;
		this.user = user;
		this.teachSub = teachSub;
		this.rating = rating;
	}
	public TeacherEntityDTO(TeacherEntity teacher) {
		this.id = teacher.getId();
		this.code = teacher.getCode();
		this.titli = teacher.getTitli();
		this.parson = teacher.getParson();
		this.role = teacher.getRole();
		this.user = teacher.getUser();
		this.teachSub = teacher.getTeachSub();
		this.rating = teacher.getRating();
	}
	public TeacherEntityDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
}
	