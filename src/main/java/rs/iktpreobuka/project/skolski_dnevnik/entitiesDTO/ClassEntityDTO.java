package rs.iktpreobuka.project.skolski_dnevnik.entitiesDTO;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;

import rs.iktpreobuka.project.skolski_dnevnik.entities.ClassEntity;
import rs.iktpreobuka.project.skolski_dnevnik.entities.StudentEntity;
import rs.iktpreobuka.project.skolski_dnevnik.entities.TeachSubEntity;
import rs.iktpreobuka.project.skolski_dnevnik.entities.enums.EHalfYear;
import rs.iktpreobuka.project.skolski_dnevnik.entities.enums.SchoolYear;
import rs.iktpreobuka.project.skolski_dnevnik.utils.Views;

public class ClassEntityDTO {
	
	
	private Integer id;
	private Integer numbOfStu;
	private Integer classId;
	private SchoolYear year;
	private EHalfYear halfYear;
	@JsonManagedReference
	private TeachSubEntity teaches;
	
	@JsonBackReference
	private List<StudentEntity> students = new ArrayList<>();
	
	public TeachSubEntity getTeaches() {
		return teaches;
	}

	public void setTeaches(TeachSubEntity teaches) {
		this.teaches = teaches;
	}

	public List<StudentEntity> getStudents() {
		return students;
	}

	public void setStudents(List<StudentEntity> students) {
		this.students = students;
	}

	@JsonProperty("ID")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	@JsonView(Views.Admin.class)
	public Integer getNumbOfStu() {
		return numbOfStu;
	}

	public void setNumbOfStu(Integer numbOfStu) {
		this.numbOfStu = numbOfStu;
	}
	@JsonView(Views.Student.class)
	public Integer getClassId() {
		return classId;
	}

	public void setClassId(Integer classId) {
		this.classId = classId;
	}
	@JsonView(Views.Admin.class)
	public SchoolYear getYear() {
		return year;
	}

	public void setYear(SchoolYear year) {
		this.year = year;
	}
	@JsonView(Views.Admin.class)
	public EHalfYear getHalfYear() {
		return halfYear;
	}

	public void setHalfYear(EHalfYear halfYear) {
		this.halfYear = halfYear;
	}

	

	public ClassEntityDTO(Integer id, Integer numbOfStu, Integer classId, SchoolYear year, EHalfYear halfYear,
			List<StudentEntity> students, TeachSubEntity teaches) {
		super();
		this.id = id;
		this.numbOfStu = numbOfStu;
		this.classId = classId;
		this.year = year;
		this.halfYear = halfYear;
		this.students = students;
		this.teaches = teaches;
	}
	public ClassEntityDTO(ClassEntity classes) {
		
		this.id = classes.getId();
		this.numbOfStu = classes.getNumbOfStu();
		this.classId = classes.getClassId();
		this.halfYear = classes.getHalfYear();
		this.students = classes.getStudents();
		this.year = classes.getYear();
		this.teaches = classes.getTeaches();
	}

	public ClassEntityDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
