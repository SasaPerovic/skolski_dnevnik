package rs.iktpreobuka.project.skolski_dnevnik.entitiesDTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;

import rs.iktpreobuka.project.skolski_dnevnik.utils.Views;

public class SubjectEntityDTO {
	
	
	private Integer id;
	private String subName;
	private Integer subId;
	private Double fond;
	
	@JsonProperty("ID")
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@JsonView(Views.Teacher.class)
	public String getSubName() {
		return subName;
	}
	public void setSubName(String subName) {
		this.subName = subName;
	}
	@JsonView(Views.Teacher.class)
	public Integer getSubId() {
		return subId;
	}
	public void setSubId(Integer subId) {
		this.subId = subId;
	}
	@JsonView(Views.Teacher.class)
	public Double getFond() {
		return fond;
	}
	public void setFond(Double fond) {
		this.fond = fond;
	}
	public SubjectEntityDTO(Integer id, String subName, Integer subId, Double fond) {
		super();
		this.id = id;
		this.subName = subName;
		this.subId = subId;
		this.fond = fond;
	}
	public SubjectEntityDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
