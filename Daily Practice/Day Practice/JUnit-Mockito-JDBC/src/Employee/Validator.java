package Employee;
class Validator {
	public boolean validateName(String name) {
		if(name.length()>8) {
			return true;
		}
		else {
			return false;
		}
	}
	public boolean validateAge(int age) {
		if(age>17 && age<61) {
			return true;
		}
		else {
			return false;
		}
	}
	public void validate(Employee emp) throws InvalidAgeException,InvalidNameException{
		if(!validateName(emp.getName())) {
			throw new InvalidNameException("Name Issue");
		}
		if(!validateAge(emp.getAge())) {
			throw new InvalidAgeException("Age Issue");
		}
	}
}
