package com.cg.main.feign;

import com.cg.main.dto.CarDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "car-rental-service", fallback = CarRentalFeignClientFallback.class)
public interface CarRentalFeignClient {

    @GetMapping("/api/cars/available")
    List<CarDTO> getAvailableCars();
}