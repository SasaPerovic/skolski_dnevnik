package rs.iktpreobuka.project.skolski_dnevnik.entitiesDTO;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonView;

import rs.iktpreobuka.project.skolski_dnevnik.entities.AdminEntity;
import rs.iktpreobuka.project.skolski_dnevnik.entities.ParsonEntity;
import rs.iktpreobuka.project.skolski_dnevnik.entities.RoleEntety;
import rs.iktpreobuka.project.skolski_dnevnik.entities.UserEntity;
import rs.iktpreobuka.project.skolski_dnevnik.utils.Views;

public class AdminEntityDTO {
	
	private Integer id;
	private String code;
	private RoleEntety role;
	private ParsonEntity parson;
	private UserEntity user;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	@JsonManagedReference
	@JsonView(Views.Admin.class)
	public RoleEntety getRole() {
		return role;
	}
	public void setRole(RoleEntety role) {
		this.role = role;
	}
	@JsonManagedReference
	@JsonView(Views.Admin.class)
	public ParsonEntity getParson() {
		return parson;
	}
	public void setParson(ParsonEntity parson) {
		this.parson = parson;
	}
	@JsonManagedReference
	@JsonView(Views.Admin.class)
	public UserEntity getUser() {
		return user;
	}
	public void setUser(UserEntity user) {
		this.user = user;
	}
	public AdminEntityDTO(Integer id, String code, RoleEntety role, ParsonEntity parson, UserEntity user) {
		super();
		this.id = id;
		this.code = code;
		this.role = role;
		this.parson = parson;
		this.user = user;
	}
	public AdminEntityDTO(AdminEntity admin) {
		this.id = admin.getId();
		this.code = admin.getCode();
		this.role = admin.getRole();
		this.parson = admin.getParson();
		this.user = admin.getUser();
	}
	public AdminEntityDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
