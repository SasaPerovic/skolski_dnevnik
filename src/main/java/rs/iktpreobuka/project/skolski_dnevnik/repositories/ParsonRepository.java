package rs.iktpreobuka.project.skolski_dnevnik.repositories;

import org.springframework.data.repository.CrudRepository;
import rs.iktpreobuka.project.skolski_dnevnik.entities.ParsonEntity;
import rs.iktpreobuka.project.skolski_dnevnik.entitiesDTO.ParsonEntityDTO;
public interface ParsonRepository extends CrudRepository<ParsonEntity, Integer> {

	ParsonEntity save(ParsonEntityDTO newParson);

//	ParsonEntity save(ParsonEntityDTO newParson);

}
