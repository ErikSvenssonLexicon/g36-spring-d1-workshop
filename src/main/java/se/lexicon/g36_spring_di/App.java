package se.lexicon.g36_spring_di;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import se.lexicon.g36_spring_di.config.AppConfig;

public class App 
{
    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext context =
        		new AnnotationConfigApplicationContext(AppConfig.class);     
        
        
        
        
        context.close();
    }
}
