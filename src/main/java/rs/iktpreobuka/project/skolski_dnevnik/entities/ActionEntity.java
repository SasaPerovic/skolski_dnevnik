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
@Table(name="Action")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ActionEntity {
	
	@Id
	@GeneratedValue
	private Integer id;
	@Version
	private Integer version;
	@Column(name = "Test")
	private String test;
	@Column(name="Oral_exam")
	private String oral_exam;
	@Column(name="Drawing")
	private String drawing;
	
	 @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
		@JoinTable(name = "Subject_Action", joinColumns =
		{ @JoinColumn(name = "Action_id", nullable = false, updatable = false) },
		inverseJoinColumns = { @JoinColumn(name = "Subject_id", nullable = false,
		updatable = false) })
		protected List<ActionEntity> actions = new ArrayList<>();
	 
	 @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
		@JoinTable(name = "Teacher_Action", joinColumns =
		{ @JoinColumn(name = "Action_id", nullable = false, updatable = false) },
		inverseJoinColumns = { @JoinColumn(name = "Teacher_id", nullable = false,
		updatable = false) })
		protected List<ActionEntity> actionTeacher = new ArrayList<>();
	 
	 @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
		@JoinTable(name = "Rating_Action", joinColumns =
		{ @JoinColumn(name = "Action_id", nullable = false, updatable = false) },
		inverseJoinColumns = { @JoinColumn(name = "Rating_id", nullable = false,
		updatable = false) })
		protected List<ActionEntity> actionRating = new ArrayList<>();
	 
	
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
	public String getTest() {
		return test;
	}
	public void setTest(String test) {
		this.test = test;
	}
	public String getOral_exam() {
		return oral_exam;
	}
	public void setOral_exam(String oral_exam) {
		this.oral_exam = oral_exam;
	}
	public String getDrawing() {
		return drawing;
	}
	public void setDrawing(String drawing) {
		this.drawing = drawing;
	}
	public ActionEntity(Integer id, Integer version, String test, String oral_exam, String drawing) {
		super();
		this.id = id;
		this.version = version;
		this.test = test;
		this.oral_exam = oral_exam;
		this.drawing = drawing;
	}
	public ActionEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
