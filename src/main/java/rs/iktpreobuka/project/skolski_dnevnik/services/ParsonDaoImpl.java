package rs.iktpreobuka.project.skolski_dnevnik.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.iktpreobuka.project.skolski_dnevnik.entities.AddressEntity;
import rs.iktpreobuka.project.skolski_dnevnik.entities.ParsonEntity;
import rs.iktpreobuka.project.skolski_dnevnik.repositories.AddressRepository;
import rs.iktpreobuka.project.skolski_dnevnik.repositories.ParsonRepository;


@Service
public class ParsonDaoImpl implements ParsonDao {
	
	@PersistenceContext
	EntityManager em;
	
	@Autowired
	private ParsonRepository parsonRepo;
	@Autowired
	private AddressRepository addressRepo;
		
		@SuppressWarnings("unchecked")
		@Override
		public List<ParsonEntity> findPersonByUserName (String username){
			String sql = "select parson "
					+ "from ParsonEntity as parson "
					+ "left join fetch parson.user u "
					+ "where u.username= :username ";
			
			Query query = em.createQuery(sql);
			query.setParameter("username", username);
			
			List<ParsonEntity> result = new ArrayList<>();
			result = query.getResultList();
			return result;
			
		}
		
		@Override
		public List<ParsonEntity>getAllParsons(){
			List<ParsonEntity> parsons= (List<ParsonEntity>) parsonRepo.findAll();
			return parsons;
		}
		@SuppressWarnings("unchecked")
		@Override
		public List<ParsonEntity>getParsonByname(String name){
		
				String sql = "select parson "
						+ "from ParsonEntity as parson "
						+ "where parson.name = :name ";
				
				Query query = em.createQuery(sql);
				query.setParameter("name", name);
				
				List<ParsonEntity> result = new ArrayList<>();
				result = query.getResultList();
				return result;	
		}
		@SuppressWarnings("unchecked")
		@Override
		public List<ParsonEntity>getParsonsByLastName(String lastname){
			String sql = "select parson "
					+ "from ParsonEntity as parson "
					+ "where parson.lastname = :lastname ";
			
			Query query = em.createQuery(sql);
			query.setParameter("lastname", lastname);
			
			List<ParsonEntity> result = new ArrayList<>();
			result = query.getResultList();
			return result;	
		}
		
		@SuppressWarnings("unchecked")
		@Override
		public List<ParsonEntity>getParsonsById(Integer id){
			String sql = "select parson "
					+ "from ParsonEntity parson, AddressEntity a"
					+ " left join fetch parson.user parsona "
					+ "where parson.id = :id ";

			Query query = em.createQuery(sql);
			query.setParameter("id", id);
			
			List<ParsonEntity> result = new ArrayList<>();
			result = query.getResultList();
			return result;	
		}
		
		@SuppressWarnings("unused")
		@Override
		public ParsonEntity createNewParson(ParsonEntity newParson ) {
			
			ParsonEntity parson = new ParsonEntity();
			
				if(parson == null) {
					return null;
			
				}else {
					parson.setLastname(newParson.getLastname());
					parson.setName(newParson.getName());
					parson.setEmail(newParson.getEmail());
					parson.setDayOfBrth(newParson.getDayOfBrth());
					parson.setPhoneNumber(newParson.getPhoneNumber());
					
					
				}
					return parsonRepo.save(parson);
		}
	
		@Override
		public ParsonEntity updataParson(ParsonEntity newParson, Integer id) {
			ParsonEntity parson = parsonRepo.findById(id).get();
			if (parson == null) {
				return null;
			}else if (newParson == null) {
				return null;
			}else {
				parson.setLastname(newParson.getLastname());
				parson.setName(newParson.getName());
				parson.setEmail(newParson.getEmail());
				parson.setDayOfBrth(newParson.getDayOfBrth());
				parson.setPhoneNumber(newParson.getPhoneNumber());
				parson.setUser(newParson.getUser());
				parson.setAddress(newParson.getAddress());
				parson.setRole(newParson.getRole());
			}
			return parsonRepo.save(parson);
		}
		@Override
		public boolean deleteParson(Integer id) {
			Optional<ParsonEntity> parson = parsonRepo.findById(id);
			if (parson.isPresent()) {
				parsonRepo.deleteById(id);
				return true;
			}
				return false;
		}
//		@Override
//		public ParsonEntity createNewParson(ParsonEntity newParson, Integer addresId, Integer userId) {
//			ParsonEntity parson = new ParsonEntity();
//			AddressEntity address = addressRepo.findById(addresId).get();
//			UserEntity user = userRepo.findById(userId).get();
//			if(newParson == null) {
//				return null;
//			}else if(address == null) {
//				return null;
//			}else if(user==null) {
//				return null;
//			}else {
//				parson.setLastname(newParson.getLastname());
//				parson.setName(newParson.getName());
//				parson.setEmail(newParson.getEmail());
//				parson.setDayOfBrth(newParson.getDayOfBrth());
//				parson.setPhoneNumber(newParson.getPhoneNumber());
//				parson.setAddress(address);
//				parson.setUser(user);
//				
//			}
//			return parsonRepo.save(parson);
//		}
//
//		@Override
//		public ParsonEntity updataParson(ParsonEntity newParson) {
//			// TODO Auto-generated method stub
//			return null;
//		}

		@Override
		public ParsonEntity createNewParson(ParsonEntity newParson, Integer id) {
			// TODO Auto-generated method stub
			return null;
		}

}
