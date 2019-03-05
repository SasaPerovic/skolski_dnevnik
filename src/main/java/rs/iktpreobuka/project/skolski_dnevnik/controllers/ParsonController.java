package rs.iktpreobuka.project.skolski_dnevnik.controllers;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import rs.iktpreobuka.project.skolski_dnevnik.entities.ParsonEntity;
import rs.iktpreobuka.project.skolski_dnevnik.entitiesDTO.ParsonEntityDTO;
import rs.iktpreobuka.project.skolski_dnevnik.repositories.ParsonRepository;
import rs.iktpreobuka.project.skolski_dnevnik.services.ParsonDao;
import rs.iktpreobuka.project.skolski_dnevnik.utils.RestError;
import rs.iktpreobuka.project.skolski_dnevnik.utils.Views;

@RestController
@CrossOrigin
@RequestMapping(path = "/api/v1/parson")
public class ParsonController {

	@Autowired
	private ParsonDao parsonDao;
	@Autowired
	private ParsonRepository parsonRepo;

	@RequestMapping(method = RequestMethod.GET)
	@JsonView(Views.Admin.class)
	public ResponseEntity<List<ParsonEntityDTO>> getAllParsons() {
		List<ParsonEntityDTO> parsonDTO = new ArrayList<>();
		List<ParsonEntity> parson = parsonDao.getAllParsons();
		
		for (ParsonEntity p : parson) {
			parsonDTO.add(new ParsonEntityDTO(p));
		}
		return new ResponseEntity<>(parsonDTO, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "name/{name}")
	@JsonView(Views.Teacher.class)
	public ResponseEntity<?> getParsonByName(@PathVariable String name) {
		List<ParsonEntityDTO> parsonDTO = new ArrayList<>();
		List<ParsonEntity> parson = parsonDao.getParsonByname(name);
		for (ParsonEntity p : parson) {
			parsonDTO.add(new ParsonEntityDTO(p));
		}
		return new ResponseEntity<>(parsonDTO, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "lastname/{lastname}")
	@JsonView(Views.Teacher.class)
	public ResponseEntity<?> getParsonByLastName(@PathVariable String lastname) {
		List<ParsonEntityDTO> parsonDTO = new ArrayList<>();
		List<ParsonEntity> parson = parsonDao.getParsonsByLastName(lastname);
		for (ParsonEntity p : parson) {
			parsonDTO.add(new ParsonEntityDTO(p));
		}
		return new ResponseEntity<>(parsonDTO, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/id/{id}")
	@JsonView(Views.Admin.class)
	public ResponseEntity<?> getParsonById(@PathVariable Integer id) {
		List<ParsonEntityDTO> parsonDTO = new ArrayList<>();
		List<ParsonEntity> parson = parsonDao.getParsonsById(id);
		for (ParsonEntity p : parson) {
			parsonDTO.add(new ParsonEntityDTO(p));
		}
		return new ResponseEntity<>(parsonDTO, HttpStatus.OK);
	}//vraca duplo

	@RequestMapping(method = RequestMethod.POST)
	@JsonView(Views.Admin.class)
	public ResponseEntity<?> seveNewParson(@RequestBody ParsonEntity newParson) {
		try {
			ParsonEntityDTO parsonDTO = new ParsonEntityDTO();
			ParsonEntity parson = parsonDao.createNewParson(newParson);

			if (parson != null) {
				return new ResponseEntity<>(parson, HttpStatus.OK);

			}else {
			return new ResponseEntity<RestError>(new RestError("Failed to create user"), HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			return new ResponseEntity<RestError>(new RestError("Exception occured :" + e.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}// neradi
	
//	@RequestMapping(method = RequestMethod.POST)
//	public ParsonEntity addNewParson (@RequestBody ParsonEntityDTO newParson, Integer id) {
//		ParsonEntityDTO parson = new ParsonEntityDTO();
//		parson.setLastname(newParson.getLastname());
//		parson.setName(newParson.getName());
//		parson.setEmail(newParson.getEmail());
//		parson.setDayOfBrth(newParson.getDayOfBrth());
//		parson.setPhoneNumber(newParson.getPhoneNumber());
//		parson.setUser(newParson.getUser());
//		parson.setAddress(newParson.getAddress());
//		parson.setRole(newParson.getRole());
//		
//		return parsonRepo.save(newParson);
//	}
	
//	@RequestMapping(method = RequestMethod.PUT, value = "/{id}")
//	@JsonView(Views.Admin.class)
//	public ResponseEntity<?> updateParson(@PathVariable Integer id, @RequestBody ParsonEntity newParson) {
//		try {
//			ParsonEntity parson = parsonDao.updataParson(newParson, id);
//			if (parson != null) {
//				return new ResponseEntity<>(parson, HttpStatus.OK);
//			}
//			return new ResponseEntity<RestError>(new RestError("Failed to update user"), HttpStatus.BAD_REQUEST);
//		} catch (Exception e) {
//			return new ResponseEntity<RestError>(new RestError("Exception occured :" + e.getMessage()),
//					HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//	}//neradi

	@RequestMapping(method = RequestMethod.GET, value = "user/{username}")
	@JsonView(Views.Student.class)
	public ResponseEntity<?> getUserByUserName(@PathVariable String username) {

			List<ParsonEntityDTO> parsonDTO = new ArrayList<>();
			List<ParsonEntity> parson = parsonDao.findPersonByUserName(username);
			
			for (ParsonEntity p : parson) {
				parsonDTO.add(new ParsonEntityDTO(p));
			}
			return new ResponseEntity<>(parsonDTO,HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	@JsonView(Views.Admin.class)
	public ResponseEntity<?> delitParson(@PathVariable Integer id) {
		try {
			if(parsonDao.deleteParson(id)) {
				return new ResponseEntity<RestError>(new RestError("Delice succesfully"),HttpStatus.OK);
			}else {
				return new ResponseEntity<RestError>(new RestError("Parson not found"), HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<RestError>(new RestError("Can not delit that parson"),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
