package in.cg.Main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import in.cg.beans.Student;
import in.cg.resources.JavaConfigFile;

public class Main {
	public static void main(String[] args) {
		ApplicationContext context=new AnnotationConfigApplicationContext(JavaConfigFile.class);
		Student s1=(Student) context.getBean(Student.class);
		s1.display();
	}
}
