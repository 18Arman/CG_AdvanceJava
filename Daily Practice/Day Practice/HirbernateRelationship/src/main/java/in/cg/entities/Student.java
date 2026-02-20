package in.cg.entities;
import java.util.List;
import jakarta.persistence.*;
@Table
@Entity
public class Student {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column
	private String name;
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(
				name="student_course",
				joinColumns=@JoinColumn(name="student_id"),
				inverseJoinColumns=@JoinColumn(name="course_id")
			)
	private List<Course> courses;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<Course> getCourses() {
		return courses;
	}
	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
