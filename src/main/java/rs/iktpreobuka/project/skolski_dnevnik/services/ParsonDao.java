package rs.iktpreobuka.project.skolski_dnevnik.services;

import java.util.List;
import rs.iktpreobuka.project.skolski_dnevnik.entities.ParsonEntity;

public interface ParsonDao {
	
	
	public List<ParsonEntity>getAllParsons();
	List<ParsonEntity> getParsonByname(String name);
	List<ParsonEntity> getParsonsByLastName(String lastname);
	
	List<ParsonEntity> getParsonsById(Integer id);


	boolean deleteParson(Integer id);
	List<ParsonEntity> findPersonByUserName(String username);
	ParsonEntity createNewParson(ParsonEntity newParson, Integer id);
	ParsonEntity createNewParson(ParsonEntity newParson);
	ParsonEntity updataParson(ParsonEntity newParson, Integer id);
	

}
