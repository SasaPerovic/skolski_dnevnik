package rs.iktpreobuka.project.skolski_dnevnik.entitiesDTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;

import rs.iktpreobuka.project.skolski_dnevnik.entities.enums.HalfYear;
import rs.iktpreobuka.project.skolski_dnevnik.entities.enums.Year;
import rs.iktpreobuka.project.skolski_dnevnik.utils.Views;

public class ClassEntityDTO {
	
	
	private Integer id;
	private Integer numbOfStu;
	private Integer classId;
	private Year year;
	private HalfYear halfYear;
	
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
	public Year getYear() {
		return year;
	}

	public void setYear(Year year) {
		this.year = year;
	}
	@JsonView(Views.Admin.class)
	public HalfYear getHalfYear() {
		return halfYear;
	}

	public void setHalfYear(HalfYear halfYear) {
		this.halfYear = halfYear;
	}

	public ClassEntityDTO(Integer id, Integer numbOfStu, Integer classId, Year year, HalfYear halfYear) {
		super();
		this.id = id;
		this.numbOfStu = numbOfStu;
		this.classId = classId;
		this.year = year;
		this.halfYear = halfYear;
	}

	public ClassEntityDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
