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
import javax.persistence.Table;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="Subject")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class SubjectEntity {
	
	@Id
	@GeneratedValue
	private Integer id;
	@Version
	private Integer version;
	@Column(name="Subject_Name")
	private String subName;
	@Column(name="SubjectID")
	private Integer subId;
	@Column(name="Fond")
	private Double fond;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	@JoinTable(name = "Student_Subject", joinColumns =
	{ @JoinColumn(name = "Subject_id", nullable = false, updatable = false) },
	inverseJoinColumns = { @JoinColumn(name = "Student_id", nullable = false,
	updatable = false) })
	protected List<SubjectEntity> subjects = new ArrayList<>();
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	@JoinTable(name = "Teacher_Subject", joinColumns =
	{ @JoinColumn(name = "Subject_id", nullable = false, updatable = false) },
	inverseJoinColumns = { @JoinColumn(name = "Teacher_id", nullable = false,
	updatable = false) })
	protected List<SubjectEntity> subject = new ArrayList<>();
	

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	@JoinTable(name = "Reating_Subject", joinColumns =
	{ @JoinColumn(name = "Subject_id", nullable = false, updatable = false) },
	inverseJoinColumns = { @JoinColumn(name = "Rating_id", nullable = false,
	updatable = false) })
	protected List<SubjectEntity> subjectRating = new ArrayList<>();
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	@JoinTable(name = "Subject_Action", joinColumns =
	{ @JoinColumn(name = "Subject_id", nullable = false, updatable = false) },
	inverseJoinColumns = { @JoinColumn(name = "Actoin_id", nullable = false,
	updatable = false) })
	protected List<SubjectEntity> subjectAction = new ArrayList<>();
	
	
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
	public String getSubName() {
		return subName;
	}
	public void setSubName(String subName) {
		this.subName = subName;
	}
	public Integer getSubId() {
		return subId;
	}
	public void setSubId(Integer subId) {
		this.subId = subId;
	}
	public Double getFond() {
		return fond;
	}
	public void setFond(Double fond) {
		this.fond = fond;
	}
	public SubjectEntity(Integer id, Integer version, String subName, Integer subId, Double fond) {
		super();
		this.id = id;
		this.version = version;
		this.subName = subName;
		this.subId = subId;
		this.fond = fond;
	}
	public SubjectEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
