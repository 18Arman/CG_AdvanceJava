package in.cg.entities;

import jakarta.persistence.*;
@Entity
@Table
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="Id")
	private Profile profileId;
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Profile getPno() {
		return profileId;
	}
	public void setPno(Profile pno) {
		this.profileId = pno;
	}
	
}
