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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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

	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	@JoinTable(name = "Teacher_Subject", joinColumns =
	{@JoinColumn(name = "Teacher_id", nullable = false, updatable = false) },
	inverseJoinColumns = { @JoinColumn(name = "Subject_id",
	nullable = false, updatable = false) })
	protected List<TeacherEntity> teachers = new ArrayList<>();
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	@JoinTable(name = "Teacher_Action", joinColumns =
	{@JoinColumn(name = "Teacher_id", nullable = false, updatable = false) },
	inverseJoinColumns = { @JoinColumn(name = "Action_id",
	nullable = false, updatable = false) })
	protected List<TeacherEntity> teacherAction = new ArrayList<>();
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	@JoinTable(name = "Teacher_Rating", joinColumns =
	{@JoinColumn(name = "Teacher_id", nullable = false, updatable = false) },
	inverseJoinColumns = { @JoinColumn(name = "Rating_id",
	nullable = false, updatable = false) })
	protected List<TeacherEntity> teacherRating = new ArrayList<>();
	
	
//	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
//	@JoinColumn(name = "person")
//	private PersonEntity person;
	
//	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
//	@JoinColumn(name = "role")
//	private RoleEntity role;
	
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name = "user")
	private UserEntity user;
	
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
	public TeacherEntity(Integer code, String titli) {
		super();
		this.code = code;
		this.titli = titli;
	}
	public TeacherEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
	