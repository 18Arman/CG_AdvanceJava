package com.lpu.TestMaven.entities;

import jakarta.persistence.*;
@Entity
@Table
public class Person {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="aadhar_no")//foregin key
	private AadharNo aadhar;
	public String getName() {
		return name;
	}
	public AadharNo getAadhar() {
		return aadhar;
	}
	public void setAadhar(AadharNo aadhar) {
		this.aadhar = aadhar;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}
