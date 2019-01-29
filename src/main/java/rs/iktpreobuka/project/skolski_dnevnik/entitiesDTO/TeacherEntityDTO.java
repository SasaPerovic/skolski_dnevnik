package rs.iktpreobuka.project.skolski_dnevnik.entitiesDTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;

import rs.iktpreobuka.project.skolski_dnevnik.utils.Views;

public class TeacherEntityDTO {
	
	
	private Integer id;
	private Integer code;
	private String titli;
	
	@JsonProperty("ID")
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@JsonView(Views.Teacher.class)
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	@JsonView(Views.Admin.class)
	public String getTitli() {
		return titli;
	}
	public void setTitli(String titli) {
		this.titli = titli;
	}
	public TeacherEntityDTO(Integer id, Integer code, String titli) {
		super();
		this.id = id;
		this.code = code;
		this.titli = titli;
	}
	public TeacherEntityDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
}
	