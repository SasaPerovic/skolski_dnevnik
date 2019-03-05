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


@Entity
@Table(name = "teaches")
public class TeachSubEntity {
	
	@Id
	@GeneratedValue
	private Integer id;
	@Version
	private Integer version;
	@Column(name="Fond")
	private Double fond;
	
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name = "teacher")
	private TeacherEntity teacher;
	
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name = "subject")
	private SubjectEntity subject;
	
	@OneToMany(mappedBy = "teaches", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	private List<ClassEntity> classs = new ArrayList<>(); 
	
	public Double getFond() {
		return fond;
	}
	public void setFond(Double fond) {
		this.fond = fond;
	}
	public TeacherEntity getTeacher() {
		return teacher;
	}
	public void setTeacher(TeacherEntity teacher) {
		this.teacher = teacher;
	}
	public SubjectEntity getSubject() {
		return subject;
	}
	public void setSubject(SubjectEntity subject) {
		this.subject = subject;
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
	
	public TeachSubEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
}
