package se.lexicon.g36_spring_di.data_access;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import se.lexicon.g36_spring_di.models.Student;

@Component
public class StudentDAOListImpl implements StudentDAO{
	
	private List<Student> students;
	
	

	public StudentDAOListImpl() {
		students = new ArrayList<>();
	}

	@Override
	public Student save(Student student) {
		if(!students.contains(student)) {
			students.add(student);			
		}
		return student;
	}

	@Override
	public Student find(int id) {
		return students.stream()
				.filter(student -> student.getId() == id)
				.findFirst()
				.orElseThrow(RuntimeException::new);
	}

	@Override
	public List<Student> findAll() {
		return new ArrayList<>(students);
	}

	@Override
	public void delete(int id) {
		Optional.ofNullable(find(id)).ifPresent(students::remove);		
	}

}
