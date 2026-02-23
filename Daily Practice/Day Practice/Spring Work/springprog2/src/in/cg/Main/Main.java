package in.cg.Main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import in.cg.beans.Student;
import in.cg.resources.SpringJavaConfigFile;

public class Main {
	public static void main(String[] args) {
		ApplicationContext context=new AnnotationConfigApplicationContext(SpringJavaConfigFile.class);
//		Student s1=(Student)context.getBean(Student.class);
		Student s1=(Student)context.getBean("Stdid",Student.class);
		s1.display();
		Student s2=(Student)context.getBean("Stdid2",Student.class);
		s2.display();
	}
}
