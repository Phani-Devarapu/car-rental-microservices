package com.phani.devarapu.CarListing.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CarnotFoundException extends RuntimeException {

	public CarnotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	
	
	

}
