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
@Table(name="Action")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ActionEntity {
	
	@Id
	@GeneratedValue
	private Integer id;
	@Version
	private Integer version;
	@Column(name = "Test")
	private String test;
	@Column(name="Oral_exam")
	private String oral_exam;
	
	@OneToMany(mappedBy = "action", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	private List<RatingEntity> rating = new ArrayList<>();
	
	
	public List<RatingEntity> getRating() {
		return rating;
	}
	public void setRating(List<RatingEntity> rating) {
		this.rating = rating;
	}
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
	
	public ActionEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
