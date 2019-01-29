package rs.iktpreobuka.project.skolski_dnevnik.services;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;

import rs.iktpreobuka.project.skolski_dnevnik.entities.ParsonEntity;

@Service
public class ParsonDaoImpl implements ParsonDao {
	
	@PersistenceContext
	EntityManager em;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ParsonEntity> findPersonByName (String name){
		String sql = "select a from ParsonEntity a "
				+ "left join fetch a.user u wher u.name= :name";
		Query query = em.createQuery(sql);
		query.setParameter("name", name);
		
		List<ParsonEntity> result = new ArrayList<>();
		result = query.getResultList();
		return result;
		
	}
}
