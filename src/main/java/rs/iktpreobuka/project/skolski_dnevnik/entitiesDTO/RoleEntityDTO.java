package rs.iktpreobuka.project.skolski_dnevnik.entitiesDTO;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import rs.iktpreobuka.project.skolski_dnevnik.entities.AdminEntity;
import rs.iktpreobuka.project.skolski_dnevnik.entities.ParentEntity;
import rs.iktpreobuka.project.skolski_dnevnik.entities.ParsonEntity;
import rs.iktpreobuka.project.skolski_dnevnik.entities.RoleEntety;
import rs.iktpreobuka.project.skolski_dnevnik.entities.StudentEntity;
import rs.iktpreobuka.project.skolski_dnevnik.entities.TeacherEntity;
public class RoleEntityDTO {
	
	private Integer id;
	private String roleName;
	
	@JsonBackReference
	private List<ParsonEntity> parson = new ArrayList<>();
	
	@JsonBackReference
	private List<StudentEntity> students = new ArrayList<>();
	
	@JsonBackReference
	private List<ParentEntity> parents = new ArrayList<>();
	
	@JsonBackReference
	private List<AdminEntity> admins = new ArrayList<>();
	
	@JsonBackReference
	private List<TeacherEntity> teachers = new ArrayList<>();

	public List<StudentEntity> getStudents() {
		return students;
	}

	public void setStudents(List<StudentEntity> students) {
		this.students = students;
	}

	@JsonProperty("ID")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	@NotNull(message = "Role must be provided.")
	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public List<ParsonEntity> getParson() {
		return parson;
	}

	public void setParson(List<ParsonEntity> parson) {
		this.parson = parson;
	}

	public List<ParentEntity> getParents() {
		return parents;
	}

	public void setParents(List<ParentEntity> parents) {
		this.parents = parents;
	}

	public List<AdminEntity> getAdmins() {
		return admins;
	}

	public void setAdmins(List<AdminEntity> admins) {
		this.admins = admins;
	}

	public List<TeacherEntity> getTeachers() {
		return teachers;
	}

	public void setTeachers(List<TeacherEntity> teachers) {
		this.teachers = teachers;
	}

	
	public RoleEntityDTO(Integer id, String roleName, List<ParsonEntity> parson, List<StudentEntity> students,
			List<ParentEntity> parents, List<AdminEntity> admins, List<TeacherEntity> teachers) {
		super();
		this.id = id;
		this.roleName = roleName;
		this.parson = parson;
		this.students = students;
		this.parents = parents;
		this.admins = admins;
		this.teachers = teachers;
	}

	public RoleEntityDTO(RoleEntety role){
		this.id =role.getId();
		this.roleName = role.getRoleName();
		this.parson = role.getParson();
		this.parents = role.getParents();
		this.admins = role.getAdmins();
		this.teachers = role.getTeachers();
		this.students = role.getStudents();
	}

	public RoleEntityDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
}
