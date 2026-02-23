package in.cg.beans;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
@Component
public class Student {
	@Value("1001")
	private int id;
	@Value("Jerman")
	private String name;
	@Value("Gmail.com")
	private String email;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void display() {
		System.out.println("Id "+id);
		System.out.println("Name "+name);
		System.out.println("Email "+email);
	}
}
