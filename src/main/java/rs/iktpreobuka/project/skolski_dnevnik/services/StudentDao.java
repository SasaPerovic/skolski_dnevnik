package rs.iktpreobuka.project.skolski_dnevnik.services;

import java.util.List;

import rs.iktpreobuka.project.skolski_dnevnik.entities.RatingEntity;
import rs.iktpreobuka.project.skolski_dnevnik.entities.StudentEntity;
import rs.iktpreobuka.project.skolski_dnevnik.entitiesDTO.StudentEntityDTO;

public interface StudentDao {

	public List<StudentEntity> findStudentsScore (Integer id);


	


}
