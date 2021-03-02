package com.phani.devarapu.CarBooking.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.phani.devarapu.CarBooking.model.BookingCar;


@Repository
public interface BookingRepo extends JpaRepository<BookingCar, Integer> {
	
	
	BookingCar findByBookingId(int id);
}
