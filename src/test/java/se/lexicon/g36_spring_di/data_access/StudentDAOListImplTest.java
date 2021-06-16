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
	
	@BeforeEach
	void setup() {
		testObject.clear();		
	}
	
	@Test
	@DisplayName("Given Student student successfully create successfully adds student")
	void save() {
		Student student = new Student(1, "Erik Svensson");
		
		testObject.save(student);
		
		Student persisted = testObject.find(1);
		
		assertEquals(persisted, student);
	}

}
