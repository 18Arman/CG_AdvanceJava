package in.cg.Hw2ByJava;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import in.cg.beans.Address;
import in.cg.beans.Person;
import in.cg.resources.Config;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext config=new AnnotationConfigApplicationContext(Config.class);
        Address a1=(Address)config.getBean("ad1");
        Person p1=(Person)config.getBean("ps1");
        System.out.println(a1);
        System.out.println(p1);
    }
}
