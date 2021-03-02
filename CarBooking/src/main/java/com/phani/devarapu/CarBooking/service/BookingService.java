package com.phani.devarapu.CarBooking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.phani.devarapu.CarBooking.model.BookingCar;
import com.phani.devarapu.CarBooking.repo.BookingRepo;

@Service
public class BookingService {
	
	@Autowired
	private BookingRepo bookingRepo;
	
	
	
		
	
	public BookingCar addBooking(BookingCar newBooking)
	{
		BookingCar save = bookingRepo.save(newBooking);
		return save;
	}



	public BookingCar getById(int id) {
		
		BookingCar findByBookingId = bookingRepo.findByBookingId(id);
		
		return findByBookingId;
		
	}
	
	
	

}
