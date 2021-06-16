package se.lexicon.g36_spring_di.data_access;

import java.util.List;

import se.lexicon.g36_spring_di.models.Student;

public interface StudentDAO {
	
	Student save(Student student);
	Student find(int id);
	List<Student> findAll();
	void delete(int id);

}
