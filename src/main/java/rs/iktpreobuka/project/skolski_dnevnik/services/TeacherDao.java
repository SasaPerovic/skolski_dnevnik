package rs.iktpreobuka.project.skolski_dnevnik.services;

import java.util.List;

import rs.iktpreobuka.project.skolski_dnevnik.entities.SubjectEntity;
import rs.iktpreobuka.project.skolski_dnevnik.entities.TeacherEntity;

public interface TeacherDao {

	List<TeacherEntity> getTeacherById(Integer id);

	

}
