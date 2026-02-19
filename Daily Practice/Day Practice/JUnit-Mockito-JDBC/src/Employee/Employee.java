package Employee;

public class Employee {
	private String name;
	private double monthlySalary;
	private int age;
	Employee(String name,double monthlySalary,int age){
		this.name=name;
		this.monthlySalary=monthlySalary;
		this.age=age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getMonthlySalary() {
		return monthlySalary;
	}
	public void setMonthlySalary(double monthlySalary) {
		this.monthlySalary = monthlySalary;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double calculateAnnualSalary() {
		if(age>=18 && age<=50) {
			return 12*monthlySalary*1.06;
		}
		else if(age>50 && age<=60) {
			return 12*monthlySalary*1.07;
		}
		else {
			return 12*monthlySalary;
		}
	}

	public static void main(String[] args) {

		Employee emp=new Employee("Maria Francis",2000,18);
		System.out.println(emp.calculateAnnualSalary());
	}
}
