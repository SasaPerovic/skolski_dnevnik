package rs.iktpreobuka.project.skolski_dnevnik.entities;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import rs.iktpreobuka.project.skolski_dnevnik.entities.enums.Role;

@Entity
@Table(name="Parson")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ParsonEntity {

	@Id
	@GeneratedValue
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
	@Column(name="Role")
	private Role role;
	
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name = "address")
	private AddressEntity address;
	
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
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public ParsonEntity(Integer id, Integer version, String name, String lastname, String email, LocalDate dayOfBrth,
			String phoneNumber, Role role) {
		super();
		this.id = id;
		this.version = version;
		this.name = name;
		this.lastname = lastname;
		this.email = email;
		this.dayOfBrth = dayOfBrth;
		this.phoneNumber = phoneNumber;
		this.role = role;
	}
	public ParsonEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
