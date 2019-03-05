package rs.iktpreobuka.project.skolski_dnevnik.entitiesDTO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;

import rs.iktpreobuka.project.skolski_dnevnik.entities.AddressEntity;
import rs.iktpreobuka.project.skolski_dnevnik.entities.AdminEntity;
import rs.iktpreobuka.project.skolski_dnevnik.entities.ParentEntity;
import rs.iktpreobuka.project.skolski_dnevnik.entities.ParsonEntity;
import rs.iktpreobuka.project.skolski_dnevnik.entities.RoleEntety;
import rs.iktpreobuka.project.skolski_dnevnik.entities.StudentEntity;
import rs.iktpreobuka.project.skolski_dnevnik.entities.TeacherEntity;
import rs.iktpreobuka.project.skolski_dnevnik.entities.UserEntity;
import rs.iktpreobuka.project.skolski_dnevnik.utils.Views;

public class ParsonEntityDTO{
	
	
	private Integer id;
	private String name;
	private String lastname;
	private String email;
	private LocalDate dayOfBrth;
	private String phoneNumber;
	private AddressEntity address;
	private UserEntity user;
	private RoleEntety role;
	
	
	
	@JsonBackReference
	private List<AdminEntity> admins = new ArrayList<>();
	@JsonBackReference
	private List<StudentEntity> students = new ArrayList<>();
	@JsonBackReference
	private List<TeacherEntity> teachers = new ArrayList<>();
	@JsonBackReference
	private List <ParentEntity> parents = new ArrayList<>();
	
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
	public RoleEntety getRole() {
		return role;
	}
	public void setRole(RoleEntety role) {
		this.role = role;
	}
	@JsonManagedReference
	@JsonView(Views.Student.class)
	public AddressEntity getAddress() {
		return address;
	}
	public void setAddress(AddressEntity address) {
		this.address = address;
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
			String phoneNumber) {
		super();
		this.id = id;
		this.name = name;
		this.lastname = lastname;
		this.email = email;
		this.dayOfBrth = dayOfBrth;
		this.phoneNumber = phoneNumber;	
	}
	public ParsonEntityDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ParsonEntityDTO(ParsonEntity entity) {
		this.id = entity.getId();
		this.name = entity.getName();
		this.lastname = entity.getLastname();
		this.email = entity.getEmail();
		this.dayOfBrth = entity.getDayOfBrth();
		this.phoneNumber = entity.getPhoneNumber();
	}
}
