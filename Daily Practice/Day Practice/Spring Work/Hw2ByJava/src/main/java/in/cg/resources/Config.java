package in.cg.resources;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import in.cg.beans.Address;
import in.cg.beans.Person;

@Configuration
public class Config {
	@Bean
	public Address ad1() {
		Address ob1=new Address();
		ob1.setCity("Tripura");
		ob1.setPincode(-121312);
		return ob1;
	}
	@Bean
	public Person ps1() {
		Person ob1=new Person();
		ob1.setGender("Male");
		ob1.setpId(1001);
		ob1.setpName("Sanath");
		return ob1;
	}
}
