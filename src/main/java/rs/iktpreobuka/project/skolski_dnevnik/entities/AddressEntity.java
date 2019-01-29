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
@Table(name = "address")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class AddressEntity {
	@Id
	@GeneratedValue
	private Integer id;
	@Version
	private Integer version;
	@Column(name="street")
	private String street;
	@Column(name="City")
	private String city;
	@Column(name= "Country")
	private String country;
	
	@OneToMany(mappedBy = "address", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	private List<ParsonEntity> person= new ArrayList<>();
	
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
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public AddressEntity(Integer id, Integer version, String street, String city, String country) {
		super();
		this.id = id;
		this.version = version;
		this.street = street;
		this.city = city;
		this.country = country;
	}
	public AddressEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
