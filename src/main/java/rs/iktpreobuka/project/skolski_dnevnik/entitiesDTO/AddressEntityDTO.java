package rs.iktpreobuka.project.skolski_dnevnik.entitiesDTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;

import rs.iktpreobuka.project.skolski_dnevnik.utils.Views;

public class AddressEntityDTO {
	
	private Integer id;
	private String street;
	private String city;
	private String country;

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
	public AddressEntityDTO(Integer id, String street, String city, String country) {
		super();
		this.id = id;
		
		this.street = street;
		this.city = city;
		this.country = country;
	}
	public AddressEntityDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
