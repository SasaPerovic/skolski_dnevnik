package rs.iktpreobuka.project.skolski_dnevnik.entitiesDTO;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import rs.iktpreobuka.project.skolski_dnevnik.entities.ActionEntity;
import rs.iktpreobuka.project.skolski_dnevnik.entities.RatingEntity;

public class ActionEntityDTO {
	
	private Integer id;
	private String test;
	private String oral_exam;
	
	@JsonBackReference
	private List<RatingEntity> rating = new ArrayList<>();
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public List<RatingEntity> getRating() {
		return rating;
	}
	public void setRating(List<RatingEntity> rating) {
		this.rating = rating;
	}
	public String getTest() {
		return test;
	}
	public void setTest(String test) {
		this.test = test;
	}
	public String getOral_exam() {
		return oral_exam;
	}
	public void setOral_exam(String oral_exam) {
		this.oral_exam = oral_exam;
	}
	
	public ActionEntityDTO(Integer id, String test, String oral_exam, List<RatingEntity> rating) {
		super();
		this.id = id;
		this.test = test;
		this.oral_exam = oral_exam;
		this.rating = rating;
	}
	public ActionEntityDTO(ActionEntity action) {
		this.id = action.getId();
		this.test = action.getTest();
		this.oral_exam = action.getOral_exam();
		this.rating = action.getRating();
	}
	public ActionEntityDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
