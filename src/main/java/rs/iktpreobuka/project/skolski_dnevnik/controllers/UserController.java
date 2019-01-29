package rs.iktpreobuka.project.skolski_dnevnik.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController; 
import com.fasterxml.jackson.annotation.JsonView;
import rs.iktpreobuka.project.skolski_dnevnik.entities.UserEntity;
import rs.iktpreobuka.project.skolski_dnevnik.repositories.StudentRepository;
import rs.iktpreobuka.project.skolski_dnevnik.repositories.UserRepository;
import rs.iktpreobuka.project.skolski_dnevnik.utils.RestError;
import rs.iktpreobuka.project.skolski_dnevnik.utils.Views;

@RestController
@RequestMapping(path= "/api/v1/user")
public class UserController {
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private StudentRepository studentRepo;
	
	@JsonView(Views.Admin.class)
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> getAllUsers(){
		return new ResponseEntity<Iterable<UserEntity>>(userRepo.findAll(), HttpStatus.OK);
	}
	
//	@JsonView(Views.Student.class)
//	@RequestMapping(method = RequestMethod.GET,value ="/{id}" )
//	public ResponseEntity<?> getUsers(){
//		return new ResponseEntity<Iterable<UserEntity>>(userRepo.findById(id), HttpStatus.OK);
//	}
	
//	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
//	public UserEntity findUserById(@PathVariable Integer id){
//		return userRepo.findById(id).get();
//	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	@JsonView(Views.Admin.class)
	public ResponseEntity<?> getUserByID(@PathVariable Integer id) {
		try {
			UserEntity user = userRepo.findById(id).get();
			
			if ( user.getId().equals(id)) {
				return new ResponseEntity<UserEntity>(user,HttpStatus.OK);
			}
			return new ResponseEntity<RestError>(new RestError("User not found"),HttpStatus.NOT_FOUND);
		}catch (Exception e) {
			return new ResponseEntity<RestError>(new RestError("Exeption occurred:"+ e.getMessage()),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	

}
