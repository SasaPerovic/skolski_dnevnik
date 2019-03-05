package rs.iktpreobuka.project.skolski_dnevnik.entities;

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
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="Admin")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class AdminEntity {
	
	@Id
	@GeneratedValue
	private Integer id;
	@Version
	private Integer version;
	@Column
	private String code;
	
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name = "role")
	private RoleEntety role;
	
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name = "parson")
	private ParsonEntity parson;
	
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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public RoleEntety getRole() {
		return role;
	}

	public void setRole(RoleEntety role) {
		this.role = role;
	}

	public ParsonEntity getParson() {
		return parson;
	}

	public void setParson(ParsonEntity parson) {
		this.parson = parson;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public AdminEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
}
