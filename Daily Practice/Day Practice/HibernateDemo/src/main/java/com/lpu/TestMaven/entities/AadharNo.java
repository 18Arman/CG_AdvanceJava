package com.lpu.TestMaven.entities;
import jakarta.persistence.GenerationType;
import jakarta.persistence.*;
@Entity
@Table
public class AadharNo {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String number;
	public int getId() {
		return id;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
}
