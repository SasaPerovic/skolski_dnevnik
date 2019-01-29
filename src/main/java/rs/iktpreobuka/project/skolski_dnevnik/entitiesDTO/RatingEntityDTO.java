package rs.iktpreobuka.project.skolski_dnevnik.entitiesDTO;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;

import rs.iktpreobuka.project.skolski_dnevnik.entities.enums.Score;
import rs.iktpreobuka.project.skolski_dnevnik.utils.Views;

public class RatingEntityDTO {
	
	
	 private Integer id;
	 private Score score;
	 private Double finalscore;
	 private Double frstHafScore;
	 private Double secondHafScore;
	 private LocalDate date;
	 
	@JsonProperty("ID")
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@JsonView(Views.Student.class)
	public Score getScore() {
		return score;
	}
	public void setScore(Score score) {
		this.score = score;
	}
	@JsonView(Views.Student.class)
	public Double getFinalscore() {
		return finalscore;
	}
	public void setFinalscore(Double finalscore) {
		this.finalscore = finalscore;
	}
	@JsonView(Views.Student.class)
	public Double getFrstHafScore() {
		return frstHafScore;
	}
	public void setFrstHafScore(Double frstHafScore) {
		this.frstHafScore = frstHafScore;
	}
	@JsonView(Views.Student.class)
	public Double getSecondHafScore() {
		return secondHafScore;
	}
	public void setSecondHafScore(Double secondHafScore) {
		this.secondHafScore = secondHafScore;
	}
	@JsonView(Views.Student.class)
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public RatingEntityDTO(Integer id, Score score, Double finalscore, Double frstHafScore,
			Double secondHafScore, LocalDate date) {
		super();
		this.id = id;
		this.score = score;
		this.finalscore = finalscore;
		this.frstHafScore = frstHafScore;
		this.secondHafScore = secondHafScore;
		this.date = date;
	}
	public RatingEntityDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	 
	 

}
