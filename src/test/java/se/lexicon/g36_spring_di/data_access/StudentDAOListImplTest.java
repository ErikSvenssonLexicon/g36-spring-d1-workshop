package se.lexicon.g36_spring_di.data_access;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import se.lexicon.g36_spring_di.config.AppConfig;
import se.lexicon.g36_spring_di.models.Student;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = AppConfig.class)
public class StudentDAOListImplTest {
	
	@Autowired private StudentDAOListImpl testObject;
	
	private Student testStudent;
	
	@BeforeEach
	void setup() {
		testObject.clear();
		testStudent = new Student(1, "Test testsson");
		testObject.save(testStudent);
	}
	
	@Test
	@DisplayName("Given Student student successfully create successfully adds student")
	void save() {
		Student student = new Student(2, "Erik Svensson");
		
		testObject.save(student);
		
		Student persisted = testObject.find(2);
		
		assertEquals(persisted, student);
	}
	
	@Test
	@DisplayName("Adding Student student twice create will not add same object twice")
	void save_duplicate() {
		Student student = new Student(2, "Erik Svensson");
		
		testObject.save(student);
		testObject.save(student);
		
		
		
		
	}
	
	@Test
	@DisplayName("Given id of 1 findById return expected object")
	void findById() {
		int id = 1;
		
		Student result = testObject.find(id);
		
		assertNotNull(result);
		assertEquals(id, result.getId());		
	}
	
	@Test
	@DisplayName("given id of 2 findById throws RuntimeException")
	void findById_throws_RuntimeException() {		
		assertThrows(
				RuntimeException.class,
				() -> testObject.find(2)
		);		
	}
	
	

}
