package com.cg.main.entity;


import jakarta.persistence.*;
@Entity
@Table(name = "cars")  
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String brand; 

    @Column(nullable = false)
    private String model;    

    @Column(nullable = false)
    private String licensePlate;

    @Column(nullable = false)
    private Double pricePerDay;

    @Column(nullable = false)
    private Boolean available;

	public Car(Long id, String brand, String model, String licensePlate, Double pricePerDay, Boolean available) {
		super();
		this.id = id;
		this.brand = brand;
		this.model = model;
		this.licensePlate = licensePlate;
		this.pricePerDay = pricePerDay;
		this.available = available;
	}

	public Car() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getLicensePlate() {
		return licensePlate;
	}

	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}

	public Double getPricePerDay() {
		return pricePerDay;
	}

	public void setPricePerDay(Double pricePerDay) {
		this.pricePerDay = pricePerDay;
	}

	public Boolean getAvailable() {
		return available;
	}

	public void setAvailable(Boolean available) {
		this.available = available;
	}  
    
}