package com.phani.devarapu.CarBooking.controller;

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
	
	@Autowired
	private BookingService bookingServ;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private BookingInfoVO booingVo;
	
	
	
	@RequestMapping(value="/addBooking", method=RequestMethod.POST)
	public BookingCar addNewCar(@RequestBody BookingCar booking)
	{
		
		
		BookingCar savedBooking = bookingServ.addBooking(booking);
		
		return savedBooking;
		
		
	}
	

	@PostMapping("/bookingById/{id}")
	@ResponseBody
	public  BookingInfoVO getById(@PathVariable("id") int id)
	{
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
