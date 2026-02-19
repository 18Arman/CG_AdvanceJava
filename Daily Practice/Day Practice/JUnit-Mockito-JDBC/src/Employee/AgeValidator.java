package Employee;
class AgeValidator {
	public boolean validateAge(int age) {
		if(age>17 && age<61) {
			return true;
		}
		else {
			return false;
		}
	}
}
