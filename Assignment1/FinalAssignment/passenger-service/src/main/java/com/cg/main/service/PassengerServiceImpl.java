package com.cg.main.service;

import com.cg.main.dto.CarDTO;
import com.cg.main.dto.PassengerDTO;
import com.cg.main.entity.Passenger;
import com.cg.main.feign.CarRentalFeignClient;
import com.cg.main.repository.PassengerRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PassengerServiceImpl implements PassengerService {
    private final PassengerRepository passengerRepository;
    private final CarRentalFeignClient carRentalFeignClient; 
    public PassengerServiceImpl(PassengerRepository passengerRepository, CarRentalFeignClient carRentalFeignClient) {
		super();
		this.passengerRepository = passengerRepository;
		this.carRentalFeignClient = carRentalFeignClient;
	}
	@Override
    public List<PassengerDTO> getAllPassengers() {
        return passengerRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PassengerDTO getPassengerById(Long id) {
        Passenger passenger = passengerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Passenger not found with id: " + id));
        return convertToDTO(passenger);
    }

    @Override
    public PassengerDTO savePassenger(PassengerDTO passengerDTO) {
        Passenger passenger = convertToEntity(passengerDTO);
        return convertToDTO(passengerRepository.save(passenger));
    }

    @Override
    public void deletePassenger(Long id) {
        passengerRepository.deleteById(id);
    }


    private PassengerDTO convertToDTO(Passenger p) {
        return new PassengerDTO(p.getId(), p.getFirstName(), p.getLastName(), p.getEmail(), p.getPhone());
    }

    private Passenger convertToEntity(PassengerDTO dto) {
        return new Passenger(dto.getId(), dto.getFirstName(), dto.getLastName(), dto.getEmail(), dto.getPhone());
    }
    @Override
    public List<CarDTO> getAvailableCarsForPassenger() {
        List<CarDTO> cars = carRentalFeignClient.getAvailableCars();

        if (cars.isEmpty()) {
            System.out.println("No cars returned - service may be down or no cars available");
        }

        return cars;
    }
}
