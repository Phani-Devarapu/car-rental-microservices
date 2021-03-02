package com.phani.devarapu.CarListing.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phani.devarapu.CarListing.models.Car;
import com.phani.devarapu.CarListing.repo.CarOpe;


@Service
public class CarService {
	
	@Autowired
	private  CarOpe  carRepo;
	
	
	public List<Car> getAllCars() {
		
		List<Car> findAll = carRepo.findAll();
		
		return findAll;
		
	}
	
	
	public Car addNewCar(Car newCar)
	{
		Car savedCar = carRepo.save(newCar);
		return savedCar;
	}
	
	public Car getById(int id)
	{
		Car findById = carRepo.findByCarId(id);
		return findById;
	}
	

}
