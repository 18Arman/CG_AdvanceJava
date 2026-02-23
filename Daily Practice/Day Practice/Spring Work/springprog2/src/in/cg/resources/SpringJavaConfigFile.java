package in.cg.resources;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import in.cg.beans.Student;

@Configuration
public class SpringJavaConfigFile {
	@Bean
	public Student Stdid() {
		Student s1=new Student();
		s1.setId(1001);
		s1.setName("Sanjay");
		s1.setEmail("armankiMail");
		return s1;
	}
	@Bean
	public Student Stdid2() {
		Student s2=new Student();
		s2.setId(1002);
		s2.setName("jarman");
		s2.setEmail("gmail");
		return s2;
	}
}
