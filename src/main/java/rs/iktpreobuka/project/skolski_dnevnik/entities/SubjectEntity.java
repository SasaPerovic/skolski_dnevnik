package rs.iktpreobuka.project.skolski_dnevnik.entities;

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

@Entity
@Table(name="Subject")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class SubjectEntity {
	
	@Id
	@GeneratedValue
	private Integer id;
	@Version
	private Integer version;
	@Column(name="Subject_Name")
	private String subName;
	@Column(name="SubjectID")
	private Integer subId;
	

	@OneToMany(mappedBy = "subject", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	private List<TeachSubEntity> subjectTeach = new ArrayList<>();
	
	
	@OneToMany(mappedBy = "subject", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
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
	public Integer getVersion() {
		return version;
	}
	public List<TeachSubEntity> getSubjectTeach() {
		return subjectTeach;
	}
	public void setSubjectTeach(List<TeachSubEntity> subjectTeach) {
		this.subjectTeach = subjectTeach;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}
	public String getSubName() {
		return subName;
	}
	public void setSubName(String subName) {
		this.subName = subName;
	}
	public Integer getSubId() {
		return subId;
	}
	public void setSubId(Integer subId) {
		this.subId = subId;
	}
	public SubjectEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
