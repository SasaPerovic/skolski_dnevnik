package rs.iktpreobuka.project.skolski_dnevnik.entitiesDTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;

import rs.iktpreobuka.project.skolski_dnevnik.utils.Views;



public class StudentEntityDTO{
	
	private Integer id;
	private String code;
	
	@JsonProperty("ID")
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@JsonView(Views.Student.class)
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public StudentEntityDTO(Integer id, String code) {
		super();
		this.id = id;
		this.code = code;
	}
	public StudentEntityDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
