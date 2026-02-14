package in.cg.operation;
public class EmployeeSalaryCalculator {
	private double basicSalary;
	private double bonus;
	private double taxPercent;
	public EmployeeSalaryCalculator(double basicSalary, double bonus, double taxPercent) {
		validate(basicSalary,taxPercent);
		this.basicSalary = basicSalary;
		this.bonus = bonus;
		this.taxPercent = taxPercent;
	}
	void validate(double basicSal,double tax) {
		if (basicSal <= 0) {
			throw new IllegalArgumentException("Invalid basic salary. It must be non-negative.");
		}
		if(tax < 0 || tax > 100) {
			throw new IllegalArgumentException("Invalid tax percent. It must be between 0 and 100.");
		}
	}
	public double calculateNetSalary() {
		System.out.println("Basic Salary =" + basicSalary);
		double hra = 0.2 * basicSalary; 
		System.out.println("HRA =" + hra);
		double da = 0.1 * basicSalary; 
		System.out.println("DA =" + da);
		double grossSalary = basicSalary + hra + da+bonus;
		System.out.println("Gross =" + grossSalary);
		double tax = 0.1 * grossSalary;
		System.out.println("Tax Deduction =" + tax);
		System.out.println("Net Salary =" + (grossSalary - tax));
		return grossSalary - tax;
	}
}
