package com.cg.main.service;

import java.util.List;

import com.cg.main.dto.CarDTO;

public interface CarService {
    List<CarDTO> getAllAvailableCars();
    CarDTO getCarById(Long id);
    CarDTO saveCar(CarDTO carDTO);
    CarDTO updateCar(Long id, CarDTO carDTO);
    void deleteCar(Long id);
}