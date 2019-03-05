package rs.iktpreobuka.project.skolski_dnevnik.entitiesDTO;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;

import rs.iktpreobuka.project.skolski_dnevnik.entities.RatingEntity;
import rs.iktpreobuka.project.skolski_dnevnik.entities.SubjectEntity;
import rs.iktpreobuka.project.skolski_dnevnik.entities.TeachSubEntity;
import rs.iktpreobuka.project.skolski_dnevnik.utils.Views;

public class SubjectEntityDTO {
	
	
	private Integer id;
	private String subName;
	private Integer subId;
	
	@JsonBackReference
	private List<TeachSubEntity> subjectTeach = new ArrayList<>();
	
	@JsonBackReference
	private List<RatingEntity> rating = new ArrayList<>();
	
	public List<TeachSubEntity> getSubjectTeach() {
		return subjectTeach;
	}
	public void setSubjectTeach(List<TeachSubEntity> subjectTeach) {
		this.subjectTeach = subjectTeach;
	}
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
	
	
	public List<RatingEntity> getRating() {
		return rating;
	}
	public void setRating(List<RatingEntity> rating) {
		this.rating = rating;
	}
	
	public SubjectEntityDTO(Integer id, String subName, Integer subId, List<TeachSubEntity> subjectTeach,
			List<RatingEntity> rating) {
		super();
		this.id = id;
		this.subName = subName;
		this.subId = subId;
		this.subjectTeach = subjectTeach;
		this.rating = rating;
	}
	public SubjectEntityDTO(SubjectEntity subject) {
		this.id = subject.getId();
		this.subName = subject.getSubName();
		this.subId = subject.getSubId();
		this.subjectTeach = subject.getSubjectTeach();
		this.rating = subject.getRating();
	}
	public SubjectEntityDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
