package com.cg.main.service;

import java.util.List;

import com.cg.main.dto.CarDTO;
import com.cg.main.dto.PassengerDTO;

public interface PassengerService {
    List<PassengerDTO> getAllPassengers();
    PassengerDTO getPassengerById(Long id);
    PassengerDTO savePassenger(PassengerDTO passengerDTO);
    void deletePassenger(Long id);
    List<CarDTO> getAvailableCarsForPassenger();
}