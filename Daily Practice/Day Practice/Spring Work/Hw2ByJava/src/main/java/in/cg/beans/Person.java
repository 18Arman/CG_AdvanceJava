package in.cg.beans;

public class Person {
	@Override
	public String toString() {
		return "Person [pId=" + pId + ", pName=" + pName + ", gender=" + gender + "]";
	}
	private int pId;
	private String pName;
	private String gender;
	public int getpId() {
		return pId;
	}
	public void setpId(int pId) {
		this.pId = pId;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
}
