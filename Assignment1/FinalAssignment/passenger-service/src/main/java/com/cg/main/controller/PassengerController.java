package com.cg.main.controller;
import com.cg.main.dto.CarDTO;
import com.cg.main.dto.PassengerDTO;
import com.cg.main.service.PassengerService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/passengers")
public class PassengerController {

    private final PassengerService passengerService;
    public PassengerController(PassengerService passengerService) {
		super();
		this.passengerService = passengerService;
	}
	@GetMapping
    public ResponseEntity<List<PassengerDTO>> getAllPassengers() {
        return ResponseEntity.ok(passengerService.getAllPassengers());
    }
    @GetMapping("/{id}")
    public ResponseEntity<PassengerDTO> getPassengerById(@PathVariable Long id) {
        return ResponseEntity.ok(passengerService.getPassengerById(id));
    }
    @PostMapping
    public ResponseEntity<PassengerDTO> createPassenger(@RequestBody PassengerDTO passengerDTO) {
        return new ResponseEntity<>(passengerService.savePassenger(passengerDTO), HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePassenger(@PathVariable Long id) {
        passengerService.deletePassenger(id);
        return ResponseEntity.ok("Passenger deleted successfully");
    }
    @GetMapping("/available-cars")
    public ResponseEntity<List<CarDTO>> getAvailableCars() {
        return ResponseEntity.ok(passengerService.getAvailableCarsForPassenger());
    }
}