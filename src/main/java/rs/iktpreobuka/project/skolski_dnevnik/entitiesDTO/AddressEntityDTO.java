package rs.iktpreobuka.project.skolski_dnevnik.entitiesDTO;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;

import rs.iktpreobuka.project.skolski_dnevnik.entities.AddressEntity;
import rs.iktpreobuka.project.skolski_dnevnik.entities.ParsonEntity;
import rs.iktpreobuka.project.skolski_dnevnik.utils.Views;

public class AddressEntityDTO {
	
	private Integer id;
	private String street;
	private String city;
	private String country;

	@JsonBackReference
	private List<ParsonEntity> parson = new ArrayList<>();
	
	public List<ParsonEntity> getParson() {
		return parson;
	}
	public void setParson(List<ParsonEntity> parson) {
		this.parson = parson;
	}
	@JsonProperty("ID")
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@JsonView(Views.Student.class)
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	@JsonView(Views.Student.class)
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@JsonView(Views.Student.class)
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public AddressEntityDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AddressEntityDTO(Integer id, String street, String city, String country, List<ParsonEntity> parson) {
		super();
		this.id = id;
		this.street = street;
		this.city = city;
		this.country = country;
		this.parson = parson;
	}
	public AddressEntityDTO(AddressEntity address) {
		this.id = address.getId();
		this.street = address.getStreet();
		this.city = address.getCity();
		this.country = address.getCountry();
		this.parson = address.getPerson();
	}
	
	

}
