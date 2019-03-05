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
import rs.iktpreobuka.project.skolski_dnevnik.entities.enums.EHalfYear;
import rs.iktpreobuka.project.skolski_dnevnik.entities.enums.SchoolYear;

@Entity
@Table(name="Class")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ClassEntity {
	
	@Id
	@GeneratedValue
	private Integer id;
	@Version
	private Integer version;
	@Column(name = "Numb_Of_Students")
	private Integer numbOfStu;
	@Column(name="ClassID")
	private Integer classId;
	@Column(name="Year")
	private SchoolYear year;
	@Column(name="Half_Year")
	private EHalfYear halfYear;
	

	@OneToMany(mappedBy = "clases", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	private List<StudentEntity> students = new ArrayList<>(); 
	
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name = "teaches")
	private TeachSubEntity teaches;
	
	
	public TeachSubEntity getTeaches() {
		return teaches;
	}

	public void setTeaches(TeachSubEntity teaches) {
		this.teaches = teaches;
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

	public Integer getNumbOfStu() {
		return numbOfStu;
	}

	public void setNumbOfStu(Integer numbOfStu) {
		this.numbOfStu = numbOfStu;
	}

	public Integer getClassId() {
		return classId;
	}

	public void setClassId(Integer classId) {
		this.classId = classId;
	}

	public SchoolYear getYear() {
		return year;
	}

	public void setYear(SchoolYear year) {
		this.year = year;
	}

	public EHalfYear getHalfYear() {
		return halfYear;
	}

	public void setHalfYear(EHalfYear halfYear) {
		this.halfYear = halfYear;
	}

	public List<StudentEntity> getStudents() {
		return students;
	}

	public void setStudents(List<StudentEntity> students) {
		this.students = students;
	}

	public ClassEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
