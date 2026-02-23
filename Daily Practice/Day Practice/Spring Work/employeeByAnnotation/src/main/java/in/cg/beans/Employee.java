package in.cg.beans;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
@Component("Emp")
public class Employee {
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", salary=" + salary + "]";
	}
	@Value("1001")
	private int empId;
	@Value("Arman Soni")
	private String empName;
	@Value("80000")
	private double salary;
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
}
