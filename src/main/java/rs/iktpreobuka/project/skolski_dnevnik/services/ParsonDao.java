package rs.iktpreobuka.project.skolski_dnevnik.services;

import java.util.List;

import rs.iktpreobuka.project.skolski_dnevnik.entities.ParsonEntity;

public interface ParsonDao {
	
	public List<ParsonEntity> findPersonByName (String name);

}
