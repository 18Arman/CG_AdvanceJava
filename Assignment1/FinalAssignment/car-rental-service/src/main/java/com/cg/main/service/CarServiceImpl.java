package com.cg.main.service;

import com.cg.main.dto.CarDTO;
import com.cg.main.entity.Car;
import com.cg.main.repository.CarRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;
    CarServiceImpl(CarRepository carRepository) {
		this.carRepository = carRepository;
	}
    @Override
    public List<CarDTO> getAllAvailableCars() {
        return carRepository.findByAvailableTrue()
                .stream()
                .map(this::convertToDTO)   // Convert each Car entity → CarDTO
                .collect(Collectors.toList());
    }

    @Override
    public CarDTO getCarById(Long id) {
        Car car = carRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Car not found with id: " + id));
        return convertToDTO(car);
    }

    @Override
    public CarDTO saveCar(CarDTO carDTO) {
        Car car = convertToEntity(carDTO);
        Car savedCar = carRepository.save(car);
        return convertToDTO(savedCar);
    }

    @Override
    public CarDTO updateCar(Long id, CarDTO carDTO) {
        Car existingCar = carRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Car not found with id: " + id));
        	
        existingCar.setBrand(carDTO.getBrand());
        existingCar.setModel(carDTO.getModel());
        existingCar.setLicensePlate(carDTO.getLicensePlate());
        existingCar.setPricePerDay(carDTO.getPricePerDay());
        existingCar.setAvailable(carDTO.getAvailable());

        return convertToDTO(carRepository.save(existingCar));
    }

    @Override
    public void deleteCar(Long id) {
        carRepository.deleteById(id);
    }

    private CarDTO convertToDTO(Car car) {
        return new CarDTO(
                car.getId(),
                car.getBrand(),
                car.getModel(),
                car.getLicensePlate(),
                car.getPricePerDay(),
                car.getAvailable()
        );
    }

    private Car convertToEntity(CarDTO dto) {
        return new Car(
                dto.getId(),
                dto.getBrand(),
                dto.getModel(),
                dto.getLicensePlate(),
                dto.getPricePerDay(),
                dto.getAvailable()
        );
    }
}