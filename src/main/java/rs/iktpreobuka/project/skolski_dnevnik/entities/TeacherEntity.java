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
@Table(name="Teacher")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class TeacherEntity {
	
	@Id
	@GeneratedValue
	private Integer id;
	@Version
	private Integer version;
	@Column(name="Code")
	private Integer code;
	@Column(name="Title")
	private String titli;


	
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name = "parson")
	private ParsonEntity parson;
	
	@OneToMany(mappedBy = "teacher", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	private List<TeachSubEntity> teachSub = new ArrayList<>();
	
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name = "role")
	private RoleEntety role;
	
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name = "user")
	private UserEntity user;
	
	public List<RatingEntity> getRating() {
		return rating;
	}
	public void setRating(List<RatingEntity> rating) {
		this.rating = rating;
	}
	@OneToMany(mappedBy = "teacher", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	private List<RatingEntity> rating = new ArrayList<>();
	
	
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
	public ParsonEntity getParson() {
		return parson;
	}
	public void setParson(ParsonEntity parson) {
		this.parson = parson;
	}
	public List<TeachSubEntity> getTeachSub() {
		return teachSub;
	}
	public void setTeachSub(List<TeachSubEntity> teachSub) {
		this.teachSub = teachSub;
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
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getTitli() {
		return titli;
	}
	public void setTitli(String titli) {
		this.titli = titli;
	}
	public TeacherEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
	