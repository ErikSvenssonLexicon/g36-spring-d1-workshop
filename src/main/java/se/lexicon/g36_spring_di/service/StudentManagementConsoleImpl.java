package se.lexicon.g36_spring_di.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import se.lexicon.g36_spring_di.data_access.StudentDAO;
import se.lexicon.g36_spring_di.models.Student;
import se.lexicon.g36_spring_di.util.UserInputService;

@Service
public class StudentManagementConsoleImpl implements StudentManagement {
	
	private static int idCounter = 0;
	
	private final UserInputService userInputService;
	private final StudentDAO studentDAO;
	

	@Autowired
	public StudentManagementConsoleImpl(UserInputService userInputService, StudentDAO studentDAO) {
		this.userInputService = userInputService;
		this.studentDAO = studentDAO;
	}

	@Override
	public Student create() {
		String name = userInputService.getString();
		int id = ++idCounter;
		
		Student student = new Student(id, name);
		return save(student);		
	}

	@Override
	public Student save(Student student) {
		if(student == null) throw new RuntimeException();
		if(student.getId() == 0) throw new RuntimeException();
		return studentDAO.save(student);
	}

	@Override
	public Student find(int id) {
		return studentDAO.find(id);
	}

	@Override
	public Student remove(int id) {
		Student student = find(id);
		studentDAO.delete(id);
		return student;
	}

	@Override
	public List<Student> findAll() {
		return studentDAO.findAll();
	}

	@Override
	public Student edit(Student student) {
		if(student != null) {
			System.out.println("Enter a new name for " + student.getName());
			String newName = userInputService.getString().trim();
			student.setName(newName);			
		}
		return student;
	}

}
