package in.cg.Main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import in.cg.beans.*;

public class MainMethod {
	public static void main(String[] args) {
		
		//These two lines will start the Spring container and load the bean definitions from the specified XML file.
//		The ApplicationContext is a central interface to provide configuration for an application. 
//		It is used to load bean definitions, wire them together, and manage their lifecycle.
		String config_loc="in/cg/resources/applicationContext.xml";
		ApplicationContext context=new ClassPathXmlApplicationContext(config_loc);
		Student std=(Student) context.getBean("StdId");
		std.display();
		Student std2=(Student) context.getBean("StdId1");
		std2.display();
		
		Address ad1=(Address) context.getBean("ad1");
		ad1.display();
 	}
}
