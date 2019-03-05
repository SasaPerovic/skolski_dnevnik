package rs.iktpreobuka.project.skolski_dnevnik.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import rs.iktpreobuka.project.skolski_dnevnik.entities.RatingEntity;
import rs.iktpreobuka.project.skolski_dnevnik.entities.StudentEntity;


public interface StudentRepository extends CrudRepository<StudentEntity, Integer> {

	List<StudentEntity> findByRating(RatingEntity reting);

}
