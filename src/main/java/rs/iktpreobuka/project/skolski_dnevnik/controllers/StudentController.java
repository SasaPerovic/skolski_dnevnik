package rs.iktpreobuka.project.skolski_dnevnik.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import rs.iktpreobuka.project.skolski_dnevnik.entities.StudentEntity;
import rs.iktpreobuka.project.skolski_dnevnik.entitiesDTO.StudentEntityDTO;
import rs.iktpreobuka.project.skolski_dnevnik.services.StudentDao;
import rs.iktpreobuka.project.skolski_dnevnik.utils.RestError;
import rs.iktpreobuka.project.skolski_dnevnik.utils.Views;

@RestController
@RequestMapping(path = "/api/v1/student")
public class StudentController {
	
	@Autowired
	private StudentDao studentDao;
	
	@RequestMapping(method = RequestMethod.GET, value = "/id/{id}")
	@JsonView(Views.Student.class)
	public ResponseEntity<?> getAllSkore(@PathVariable Integer id){
	
		List<StudentEntityDTO> studentDTO = new ArrayList<>();
		List<StudentEntity> student = studentDao.findStudentsScore(id);
		for (StudentEntity s : student) {
			studentDTO.add(new StudentEntityDTO(s));
		}
		return new ResponseEntity<>(studentDTO, HttpStatus.OK);
	}//neradi
	

}
