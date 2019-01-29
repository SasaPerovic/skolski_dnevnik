package rs.iktpreobuka.project.skolski_dnevnik.repositories;
import org.springframework.data.repository.CrudRepository;
import rs.iktpreobuka.project.skolski_dnevnik.entities.UserEntity;
public interface UserRepository extends CrudRepository<UserEntity, Integer> {

}
