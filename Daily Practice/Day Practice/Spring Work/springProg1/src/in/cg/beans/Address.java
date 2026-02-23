package in.cg.beans;

public class Address {
	private String State;
	private int pincode;
	private String locName;
	public String getState() {
		return State;
	}
	public void setState(String state) {
		State = state;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public String getLocName() {
		return locName;
	}
	public void setLocName(String locName) {
		this.locName = locName;
	}
	public void display() {
		System.out.println(pincode+" "+State+" "+locName);
	}
}
