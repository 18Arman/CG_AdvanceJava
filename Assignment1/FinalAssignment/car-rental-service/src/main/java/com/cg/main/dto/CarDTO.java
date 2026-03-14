package com.cg.main.dto;
public class CarDTO {
    private Long id;
    private String brand;
    private String model;
    private String licensePlate;
    private Double pricePerDay;
    private Boolean available;
	public CarDTO(Long id, String brand, String model, String licensePlate, Double pricePerDay, Boolean available) {
		super();
		this.id = id;
		this.brand = brand;
		this.model = model;
		this.licensePlate = licensePlate;
		this.pricePerDay = pricePerDay;
		this.available = available;
	}
	public CarDTO() {
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