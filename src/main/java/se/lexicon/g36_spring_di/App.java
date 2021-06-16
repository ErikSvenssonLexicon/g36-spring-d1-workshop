package se.lexicon.g36_spring_di;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import se.lexicon.g36_spring_di.config.AppConfig;
import se.lexicon.g36_spring_di.service.StudentManagement;

public class App 
{
    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext context =
        		new AnnotationConfigApplicationContext(AppConfig.class);
        
        
        StudentManagement manager = context.getBean(StudentManagement.class); 
        
        System.out.println(manager.create());
        
        
        
        context.close();
    }
}
