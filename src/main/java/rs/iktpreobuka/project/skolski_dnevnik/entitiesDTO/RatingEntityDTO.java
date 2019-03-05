package rs.iktpreobuka.project.skolski_dnevnik.entitiesDTO;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;

import rs.iktpreobuka.project.skolski_dnevnik.entities.ActionEntity;
import rs.iktpreobuka.project.skolski_dnevnik.entities.RatingEntity;
import rs.iktpreobuka.project.skolski_dnevnik.entities.StudentEntity;
import rs.iktpreobuka.project.skolski_dnevnik.entities.SubjectEntity;
import rs.iktpreobuka.project.skolski_dnevnik.entities.TeacherEntity;
import rs.iktpreobuka.project.skolski_dnevnik.entities.enums.EHalfYear;
import rs.iktpreobuka.project.skolski_dnevnik.entities.enums.EScore;
import rs.iktpreobuka.project.skolski_dnevnik.utils.Views;

public class RatingEntityDTO {
	
	
	 private Integer id;
	 private EScore score;
	 @JsonManagedReference
	 private EHalfYear half;
	 @JsonManagedReference
	 private SubjectEntity subject;
	 @JsonManagedReference
	 private StudentEntity student;
	 @JsonManagedReference
	 private TeacherEntity teacher;
	 @JsonManagedReference
	 private ActionEntity action;
	 
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
	@JsonProperty("ID")
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@JsonView(Views.Student.class)
	public EScore getScore() {
		return score;
	}
	public void setScore(EScore score) {
		this.score = score;
	}
	
	public RatingEntityDTO(Integer id, EScore score, EHalfYear half, SubjectEntity subject, StudentEntity student, TeacherEntity teacher,
			ActionEntity action) {
		super();
		this.id = id;
		this.score = score;
		this.half = half;
		this.subject = subject;
		this.student = student;
		this.teacher = teacher;
		this.action = action;
	}
	public RatingEntityDTO(RatingEntity rating) {
		
		this.id = rating.getId();
		this.score = rating.getScore();
		this.half = rating.getHalf();
		this.subject = rating.getSubject();
		this.student = rating.getStudent();
		this.teacher = rating.getTeacher();
		this.action = rating.getAction();
	}
	public RatingEntityDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	 
	 

}
