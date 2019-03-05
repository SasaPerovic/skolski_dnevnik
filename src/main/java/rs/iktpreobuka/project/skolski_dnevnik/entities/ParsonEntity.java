package rs.iktpreobuka.project.skolski_dnevnik.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="Parson")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ParsonEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Version
	private Integer version;
	@Column(name="Frst_name")
	private String name;
	@Column(name="Last_Name")
	private String lastname;
	@Column(name="email")
	private String email;
	@Column(name="Day_of_brth")
	private LocalDate dayOfBrth;
	@Column(name="Phone_Number")
	private String phoneNumber;


	@OneToMany(mappedBy = "parson", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	private List<AdminEntity> admins = new ArrayList<>();

	@OneToMany(mappedBy = "parson", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	private List<StudentEntity> students = new ArrayList<>();

	@OneToMany(mappedBy = "parson", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	private List<TeacherEntity> teachers = new ArrayList<>();
	
	@OneToMany(mappedBy = "parson", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	private List <ParentEntity> parents = new ArrayList<>();
	
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name = "role")
	private RoleEntety role;
	
	
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name = "user")
	private UserEntity user;
	
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name = "address")
	private AddressEntity address;
	
	
	public List<AdminEntity> getAdmins() {
		return admins;
	}
	public void setAdmins(List<AdminEntity> admins) {
		this.admins = admins;
	}
	public List<StudentEntity> getStudents() {
		return students;
	}
	public void setStudents(List<StudentEntity> students) {
		this.students = students;
	}
	public List<TeacherEntity> getTeachers() {
		return teachers;
	}
	public void setTeachers(List<TeacherEntity> teachers) {
		this.teachers = teachers;
	}
	public List<ParentEntity> getParents() {
		return parents;
	}
	public void setParents(List<ParentEntity> parents) {
		this.parents = parents;
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
	public AddressEntity getAddress() {
		return address;
	}
	public void setAddress(AddressEntity address) {
		this.address = address;
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
	@NotNull(message = "First name must be provided.")
	@Size(min=2, max=30, message = "First name must be between {min} and {max} characters long.")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@NotNull(message = "Last name must be provided.")
	@Size(min=2, max=30, message = "Last name must be between {min} and {max} characters long.")
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	@NotNull(message = "Email must be provided.")
	@Pattern(regexp = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$", message="Email is not valid.")
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public LocalDate getDayOfBrth() {
		return dayOfBrth;
	}
	public void setDayOfBrth(LocalDate dayOfBrth) {
		this.dayOfBrth = dayOfBrth;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public ParsonEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
