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
import rs.iktpreobuka.project.skolski_dnevnik.entities.enums.EHalfYear;
import rs.iktpreobuka.project.skolski_dnevnik.entities.enums.EScore;

@Entity
@Table(name="Rating")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class RatingEntity {
	
	 @Id
	 @GeneratedValue
	 private Integer id;
	 @Version
	 private Integer version;
	 @Column(name="Score")
	 private EScore score;
	 @Column (name = "half_year")
	 private EHalfYear half;
	 
	 @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	 @JoinColumn(name = "subject")
	 private SubjectEntity subject;
	 
	 @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	 @JoinColumn(name = "student")
	 private StudentEntity student;
		
	 @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	 @JoinColumn(name = "teacher")
	 private TeacherEntity teacher;
	 
	 @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	 @JoinColumn(name = "action")
	 private ActionEntity action;
	
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
	public EScore getScore() {
		return score;
	}
	public void setScore(EScore score) {
		this.score = score;
	}
	
	public EHalfYear getHalf() {
		return half;
	}
	public void setHalf(EHalfYear half) {
		this.half = half;
	}
	public SubjectEntity getSubject() {
		return subject;
	}
	public void setSubject(SubjectEntity subject) {
		this.subject = subject;
	}
	public StudentEntity getStudent() {
		return student;
	}
	public void setStudent(StudentEntity student) {
		this.student = student;
	}
	public TeacherEntity getTeacher() {
		return teacher;
	}
	public void setTeacher(TeacherEntity teacher) {
		this.teacher = teacher;
	}
	public ActionEntity getAction() {
		return action;
	}
	public void setAction(ActionEntity action) {
		this.action = action;
	}
	
	public RatingEntity(Integer id, Integer version, EScore score) {
		super();
		this.id = id;
		this.version = version;
		this.score = score;
	}
	public RatingEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	 
	 

}
