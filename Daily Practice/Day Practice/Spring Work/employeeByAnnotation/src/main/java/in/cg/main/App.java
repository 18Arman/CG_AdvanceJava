package in.cg.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import in.cg.beans.Employee;
import in.cg.resources.JavaConfigFile;
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext config=new AnnotationConfigApplicationContext(JavaConfigFile.class);
        Employee e1=(Employee)config.getBean("Emp");
        System.out.println(e1);
    }
}
