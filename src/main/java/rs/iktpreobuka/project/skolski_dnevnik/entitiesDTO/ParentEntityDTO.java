package rs.iktpreobuka.project.skolski_dnevnik.entitiesDTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;

import rs.iktpreobuka.project.skolski_dnevnik.utils.Views;

public class ParentEntityDTO {

	
	private Integer id;
	private Integer numbOfStu;
	
	@JsonProperty("ID")
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@JsonView(Views.Parent.class)
	public Integer getNumbOfStu() {
		return numbOfStu;
	}
	public void setNumbOfStu(Integer numbOfStu) {
		this.numbOfStu = numbOfStu;
	}
	public ParentEntityDTO(Integer id, Integer numbOfStu) {
		super();
		this.id = id;
		this.numbOfStu = numbOfStu;
	}
	public ParentEntityDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
