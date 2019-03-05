package rs.iktpreobuka.project.skolski_dnevnik.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="Parent")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ParentEntity {

	@Id
	@GeneratedValue
	private Integer id;
	@Version
	private Integer version;
	@Column(name="number_of_students")
	private Integer numbOfStu;
	
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name = "parson")
	private ParsonEntity parson;
	
	@OneToMany(mappedBy = "parent", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	private List<StudentEntity> student= new ArrayList<>(); 
	
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name = "role")
	private RoleEntety role;
	
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name = "user")
	private UserEntity user;
	
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
	public Integer getNumbOfStu() {
		return numbOfStu;
	}
	public void setNumbOfStu(Integer numbOfStu) {
		this.numbOfStu = numbOfStu;
	}

	public ParsonEntity getParson() {
		return parson;
	}
	public void setParson(ParsonEntity parson) {
		this.parson = parson;
	}
	public List<StudentEntity> getStudent() {
		return student;
	}
	public void setStudent(List<StudentEntity> student) {
		this.student = student;
	}
	public RoleEntety getRole() {
		return role;
	}
	public void setRole(RoleEntety role) {
		this.role = role;
	}
	public UserEntity getUser() {
		return user;
	}
	public void setUser(UserEntity user) {
		this.user = user;
	}
	public ParentEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
}
