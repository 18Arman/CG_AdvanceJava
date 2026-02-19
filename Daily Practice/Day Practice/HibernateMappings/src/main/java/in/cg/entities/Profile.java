package in.cg.entities;
import jakarta.persistence.*;
public class Profile {
	private String profileNo;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int Id;
	@OneToOne(mappedBy="User")
	private User uObj;
	
	public User getuObj() {
		return uObj;
	}
	public void setuObj(User uObj) {
		this.uObj = uObj;
	}
	public String getProfileNo() {
		return profileNo;
	}
	public void setProfileNo(String profileNo) {
		this.profileNo = profileNo;
	}
	public int getId() {
		return Id;
	}
}
