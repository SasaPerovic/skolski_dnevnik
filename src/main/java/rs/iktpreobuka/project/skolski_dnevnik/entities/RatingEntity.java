package rs.iktpreobuka.project.skolski_dnevnik.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import rs.iktpreobuka.project.skolski_dnevnik.entities.enums.Score;

@Entity
@Table(name="Rating")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class RatingEntity {
	
	 @Id
	 @GeneratedValue
	 private Integer id;
	 @Version
	 private Integer version;
	 @Column(name="Score")
	 private Score score;
	 @Column(name="Final_Score")
	 private Double finalscore;
	 @Column(name="FrstHafScore")
	 private Double frstHafScore;
	 @Column(name="Second_Haf_Score")
	 private Double secondHafScore;
	 @Column(name="Date")
	 private LocalDate date;
	 
	 
	 @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
		@JoinTable(name = "Student_Rating", joinColumns =
		{ @JoinColumn(name = "Rating_id", nullable = false, updatable = false) },
		inverseJoinColumns = { @JoinColumn(name = "Student_id", nullable = false,
		updatable = false) })
		protected List<RatingEntity> ratings = new ArrayList<>();
	 
	 @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
		@JoinTable(name = "Reating_Subject", joinColumns =
		{ @JoinColumn(name = "Rating_id", nullable = false, updatable = false) },
		inverseJoinColumns = { @JoinColumn(name = "Subject_id", nullable = false,
		updatable = false) })
		protected List<RatingEntity> ratingSubject = new ArrayList<>();
	 
	 @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
		@JoinTable(name = "Rating_Action", joinColumns =
		{@JoinColumn(name = "Rating_id", nullable = false, updatable = false) },
		inverseJoinColumns = { @JoinColumn(name = "Action_id",
		nullable = false, updatable = false) })
		protected List<RatingEntity> ratingAction = new ArrayList<>();
	
	 @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
		@JoinTable(name = "Teacher_Rating", joinColumns =
		{@JoinColumn(name = "Rating_id", nullable = false, updatable = false) },
		inverseJoinColumns = { @JoinColumn(name = "Teacher_id",
		nullable = false, updatable = false) })
		protected List<RatingEntity> ratingTeacher = new ArrayList<>();
	
	 
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
	public Score getScore() {
		return score;
	}
	public void setScore(Score score) {
		this.score = score;
	}
	public Double getFinalscore() {
		return finalscore;
	}
	public void setFinalscore(Double finalscore) {
		this.finalscore = finalscore;
	}
	public Double getFrstHafScore() {
		return frstHafScore;
	}
	public void setFrstHafScore(Double frstHafScore) {
		this.frstHafScore = frstHafScore;
	}
	public Double getSecondHafScore() {
		return secondHafScore;
	}
	public void setSecondHafScore(Double secondHafScore) {
		this.secondHafScore = secondHafScore;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public RatingEntity(Integer id, Integer version, Score score, Double finalscore, Double frstHafScore,
			Double secondHafScore, LocalDate date) {
		super();
		this.id = id;
		this.version = version;
		this.score = score;
		this.finalscore = finalscore;
		this.frstHafScore = frstHafScore;
		this.secondHafScore = secondHafScore;
		this.date = date;
	}
	public RatingEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	 
	 

}
