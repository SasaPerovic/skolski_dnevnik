package rs.iktpreobuka.project.skolski_dnevnik.services;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.iktpreobuka.project.skolski_dnevnik.entities.SubjectEntity;
import rs.iktpreobuka.project.skolski_dnevnik.entities.TeacherEntity;
import rs.iktpreobuka.project.skolski_dnevnik.repositories.TeacherRepository;
@Service
public class TeacherDaoImpl implements TeacherDao {

	@PersistenceContext
	EntityManager em;
	
	@Autowired
	private TeacherRepository teacherRepo;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<TeacherEntity>getTeacherById(Integer id) {
		String sql = "select teacher "
				+ "from TeacherEntity t "
				+ "left join fetch t.parson tp "
				+ "where tp.id = :id ";
		Query query = em.createQuery(sql);
		query.setParameter("id", id);
		
		List<TeacherEntity> result = new ArrayList<>();
		result = query.getResultList();
		return result;
	}
	
	

}
