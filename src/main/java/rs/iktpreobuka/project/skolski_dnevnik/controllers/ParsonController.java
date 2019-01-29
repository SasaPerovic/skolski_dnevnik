package rs.iktpreobuka.project.skolski_dnevnik.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import rs.iktpreobuka.project.skolski_dnevnik.entities.ParsonEntity;
import rs.iktpreobuka.project.skolski_dnevnik.services.ParsonDao;

@RestController
@RequestMapping(path = "/api/v1/parson")
public class ParsonController {
	
	@Autowired
	private ParsonDao parsonDao;
	
	@RequestMapping(method = RequestMethod.GET, value = "/user/{name}")
	public List<ParsonEntity> getUserByName(@PathVariable String name){
		return parsonDao.findPersonByName(name);
	}

}
