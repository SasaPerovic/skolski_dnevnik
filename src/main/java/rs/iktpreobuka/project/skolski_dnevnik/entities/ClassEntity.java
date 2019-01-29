package rs.iktpreobuka.project.skolski_dnevnik.entities;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import rs.iktpreobuka.project.skolski_dnevnik.entities.enums.HalfYear;

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
	private Year year;
	
	@Column(name="Half_Year")
	private HalfYear halfYear;
	
	@OneToMany(mappedBy = "clases", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	private List<StudentEntity> students = new ArrayList<>(); 
	

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

	public Year getYear() {
		return year;
	}

	public void setYear(Year year) {
		this.year = year;
	}

	public HalfYear getHalfYear() {
		return halfYear;
	}

	public void setHalfYear(HalfYear halfYear) {
		this.halfYear = halfYear;
	}

	public ClassEntity(Integer id, Integer version, Integer numbOfStu, Integer classId, Year year, HalfYear halfYear) {
		super();
		this.id = id;
		this.version = version;
		this.numbOfStu = numbOfStu;
		this.classId = classId;
		this.year = year;
		this.halfYear = halfYear;
	}

	public ClassEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
