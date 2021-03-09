package com.phani.devarapu.CarBooking.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.phani.devarapu.CarBooking.model.BookingCar;
import com.phani.devarapu.CarBooking.model.BookingInfoVO;
import com.phani.devarapu.CarBooking.model.CarInfo;
import com.phani.devarapu.CarBooking.service.BookingService;



@RestController
@RequestMapping("/booking")
public class BookingController {
	
	 private static final Logger LOGGER = LoggerFactory.getLogger(BookingController.class);
		
	
	@Autowired
	private BookingService bookingServ;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private BookingInfoVO booingVo;
	
	
	
	@RequestMapping(value="/addBooking", method=RequestMethod.POST)
	public BookingCar addNewCar(@RequestBody BookingCar booking)
	{
		String nameofCurrMethod = new Object() {} 
        .getClass() 
        .getEnclosingMethod() 
        .getName(); 
		
		LOGGER.info("insdie the " + getClass().getSimpleName() + " and " + nameofCurrMethod	 + "method");
		
		LOGGER.info("The request body is " + booking.toString());
		
		BookingCar savedBooking = bookingServ.addBooking(booking);
		
		return savedBooking;
		
		
	}	
		

	@PostMapping("/bookingById/{id}")
	@ResponseBody
	public  BookingInfoVO getById(@PathVariable("id") int id)
	{
		
		 String nameofCurrMethod = new Object() {} 
         .getClass() 
         .getEnclosingMethod() 
         .getName(); 
		
		LOGGER.info("insdie the " + getClass().getSimpleName() + " and " + nameofCurrMethod	 + "method");
		
		LOGGER.info("The path variable is " + id);
		
		 BookingCar byId = bookingServ.getById(id);
		 
		 
		CarInfo car = restTemplate.getForObject("http://CAR-LISTING-SERVICE/carlist/carById/" + byId.getCarId(), CarInfo.class);
		booingVo.setBookng(byId);
		booingVo.setCar(car);
		 System.out.println(booingVo.toString());
		return booingVo;
		
		
	
	}
	
//	@RequestMapping(value="/addBooking", method=RequestMethod.POST)
//	public BookingCar addNewCar(@RequestBody BookingCar booking)
//	{
//		
//		
//		BookingCar savedBooking = bookingServ.addBooking(booking);
//		
//		return savedBooking;
//		
//		
//	}


}
