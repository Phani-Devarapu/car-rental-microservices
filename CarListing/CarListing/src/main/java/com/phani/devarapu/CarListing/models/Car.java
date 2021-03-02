package com.phani.devarapu.CarListing.models;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="cars")
public class Car {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int carId;
	
	
	private String modelName;
	private String companyName;
	private String makeYear;
	
	
	
	
	public int getCarId() {
		return carId;
	}




	public void setCarId(int carId) {
		this.carId = carId;
	}




	public String getModelName() {
		return modelName;
	}




	public void setModelName(String modelName) {
		this.modelName = modelName;
	}




	public String getCompanyName() {
		return companyName;
	}




	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}




	public String getMakeYear() {
		return makeYear;
	}




	public void setMakeYear(String makeYear) {
		this.makeYear = makeYear;
	}




	@Override
	public String toString() {
		return "Car [carId=" + carId + ", modelName=" + modelName + ", companyName=" + companyName + ", makeYear="
				+ makeYear + "]";
	}
	
	
	
	
	
	

}
