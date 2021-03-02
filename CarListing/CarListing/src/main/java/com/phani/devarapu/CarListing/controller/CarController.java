package com.phani.devarapu.CarListing.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponents;

import com.phani.devarapu.CarListing.exceptions.CarnotFoundException;
import com.phani.devarapu.CarListing.models.Car;
import com.phani.devarapu.CarListing.service.CarService;

@RestController
@RequestMapping("/carlist")

public class CarController {
	
	
	@Autowired
	private CarService carServ;
	
	@GetMapping("/all")
	public  List<Car> getAllCars()
	{
		List<Car> allCars = carServ.getAllCars();
		
		return allCars;
	}
	
	
	@RequestMapping(value="/addCar", method=RequestMethod.POST)
	public ResponseEntity<Car> addNewCar(@RequestBody Car adCar)
	{
		Car addNewCar = carServ.addNewCar(adCar);
		
		URI uri = ServletUriComponentsBuilder
											.fromCurrentRequest()
											.path("/{id}")
											.buildAndExpand(addNewCar.getCarId()).toUri();
		
		return ResponseEntity.created(uri).build();
		
	}
	
	@GetMapping("/carById/{id}")
	@ResponseBody
	public Car getById(@PathVariable("id") int id)
	{
		Car c = carServ.getById(id);
		System.out.println(c.toString());
		
		if(c == null)
		{
			throw new CarnotFoundException("The Id " + id);
		}
		
		return c;
		
	
	}

}
