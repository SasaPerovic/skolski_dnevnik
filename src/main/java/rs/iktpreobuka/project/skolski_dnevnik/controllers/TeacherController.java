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

import rs.iktpreobuka.project.skolski_dnevnik.entities.TeacherEntity;
import rs.iktpreobuka.project.skolski_dnevnik.entitiesDTO.TeacherEntityDTO;
import rs.iktpreobuka.project.skolski_dnevnik.services.TeacherDao;
import rs.iktpreobuka.project.skolski_dnevnik.utils.Views;

@RestController
@RequestMapping(path = "/api/v1/teacher")
public class TeacherController {
	
	@Autowired
	private TeacherDao teacherDao;
	
	@RequestMapping(method = RequestMethod.GET, value = "/id/{id}")
	@JsonView(Views.Teacher.class)
	public ResponseEntity<?> getTeacherById (@PathVariable Integer id){
		List<TeacherEntityDTO> teacherDTO = new ArrayList<>();
		List<TeacherEntity> teacher = teacherDao.getTeacherById(id);
		
		for(TeacherEntity t : teacher) {
			teacherDTO.add(new TeacherEntityDTO(t));
		}
		return new ResponseEntity<>(teacherDTO,HttpStatus.OK);
	}//neradi

}
