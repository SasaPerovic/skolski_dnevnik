package rs.iktpreobuka.project.skolski_dnevnik.services;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.iktpreobuka.project.skolski_dnevnik.entities.ParsonEntity;
import rs.iktpreobuka.project.skolski_dnevnik.entities.RatingEntity;
import rs.iktpreobuka.project.skolski_dnevnik.entities.StudentEntity;
import rs.iktpreobuka.project.skolski_dnevnik.repositories.StudentRepository;

@Service
public class StudentDaoImpl implements StudentDao {
	
	@PersistenceContext
	EntityManager em;
	
	@Autowired
	private StudentRepository studentRepo;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<StudentEntity> findStudentsScore (Integer id) {
		
		String sql = "select score "
				+ "from RatingEntity as r "
				+ "left join fetch r.student s "
				+ "where s.id= :id ";
		
		Query query = em.createQuery(sql);
		query.setParameter("id", id);
		
		List<StudentEntity> result = new ArrayList<>();
		result = query.getResultList();
		return result;		
	}
	
//	@Override
//	public List<StudentEntity> findSkorsForStudet (RatingEntity retingId){
//		return studentRepo.findByRating(retingId);
//	}

}
