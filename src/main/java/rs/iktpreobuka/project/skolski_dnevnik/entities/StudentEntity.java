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
@Table(name="Student")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class StudentEntity{
	
	@Id
	@GeneratedValue
	private Integer id;
	@Version
	private Integer version;
	@Column(name="Code")
	private String code;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	@JoinTable(name = "Student_Subject", joinColumns =
	{@JoinColumn(name = "Student_id", nullable = false, updatable = false) },
	inverseJoinColumns = { @JoinColumn(name = "Subject_id",
	nullable = false, updatable = false) })
	protected List<StudentEntity> students = new ArrayList<>();
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	@JoinTable(name = "Student_Rating", joinColumns =
	{@JoinColumn(name = "Student_id", nullable = false, updatable = false) },
	inverseJoinColumns = { @JoinColumn(name = "Rating_id",
	nullable = false, updatable = false) })
	protected List<StudentEntity> studentRating = new ArrayList<>();
	
	
//	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
//	@JoinColumn(name = "person")
//	private PersonEntity person;
	
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name = "parent")
	private ParentEntity parent;
	
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name = "clases")
	private ClassEntity clases;
	
//	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
//	@JoinColumn(name = "role")
//	private RoleEntity role;
	
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name = "user")
	private UserEntity user;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public StudentEntity(String code) {
		super();
		this.code = code;
	}
	public StudentEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
