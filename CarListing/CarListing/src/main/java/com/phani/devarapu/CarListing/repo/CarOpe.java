package com.phani.devarapu.CarListing.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.phani.devarapu.CarListing.models.Car;


@Repository
public interface CarOpe extends JpaRepository<Car, Integer> {

	Car findByCarId(int id);

}
