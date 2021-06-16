package se.lexicon.g36_spring_di;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import se.lexicon.g36_spring_di.config.AppConfig;
import se.lexicon.g36_spring_di.data_access.StudentDAO;
import se.lexicon.g36_spring_di.models.Student;

public class App 
{
    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext context =
        		new AnnotationConfigApplicationContext(AppConfig.class);
        
        
        StudentDAO studentDAO = context.getBean(StudentDAO.class);
        
        System.out.println(studentDAO.save
        		(
        				new Student(1, "Johny Grenander")
        		)
		);
        
        context.close();
    }
}
