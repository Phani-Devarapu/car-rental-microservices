package com.phani.devarapu.CarBooking.model;



import org.springframework.stereotype.Component;

@Component
public class BookingInfoVO {
	
	private BookingCar bookng;
	private CarInfo car;
	
	
	public BookingCar getBookng() {
		return bookng;
	}
	public void setBookng(BookingCar bookng) {
		this.bookng = bookng;
	}
	public CarInfo getCar() {
		return car;
	}
	public void setCar(CarInfo car) {
		this.car = car;
	}
	@Override
	public String toString() {
		return "BookingInfoVO [bookng=" + bookng + ", car=" + car + "]";
	}
	
	
	

}
