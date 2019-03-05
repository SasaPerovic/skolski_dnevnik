package rs.iktpreobuka.project.skolski_dnevnik.entities;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;




@Entity
@Table(name="User")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class UserEntity{
	
	@Id
	@GeneratedValue
	private Integer id;
	@Version
	private Integer version;
	@Column(name="username")
	private String username;
	@Column(name="user_password")
	private String password;
	

	@OneToMany(mappedBy = "user", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	private List<AdminEntity>  admin = new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "user", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	private List<ParsonEntity> parson = new ArrayList<>();
	
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	private List<StudentEntity> students = new ArrayList<>();
	

	@OneToMany(mappedBy = "user", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	private List<ParentEntity> parents = new ArrayList<>();
	
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	private List<TeacherEntity> teachers = new ArrayList<>();
	
	@NotNull(message = "User name must be provided.")
	@Size(min=5, max=15, message = "User name must be between {min} and {max} characters long.")
	public String getUsername() {
		return username;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	public List<ParsonEntity> getParson() {
		return parson;
	}
	public void setParson(List<ParsonEntity> parson) {
		this.parson = parson;
	}
	public List<StudentEntity> getStudents() {
		return students;
	}
	public void setStudents(List<StudentEntity> students) {
		this.students = students;
	}
	public List<ParentEntity> getParents() {
		return parents;
	}
	public void setParents(List<ParentEntity> parents) {
		this.parents = parents;
	}
	public List<TeacherEntity> getTeachers() {
		return teachers;
	}
	public void setTeachers(List<TeacherEntity> teachers) {
		this.teachers = teachers;
	}
	
	public List<AdminEntity> getAdmin() {
		return admin;
	}
	public void setAdmin(List<AdminEntity> admin) {
		this.admin = admin;
	}
	public UserEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
}
