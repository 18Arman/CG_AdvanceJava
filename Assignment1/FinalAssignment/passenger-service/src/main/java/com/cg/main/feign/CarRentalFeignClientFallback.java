package com.cg.main.feign;

import com.cg.main.dto.CarDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class CarRentalFeignClientFallback implements CarRentalFeignClient {

    @Override
    public List<CarDTO> getAvailableCars() {
        System.out.println("️ car-rental-service is DOWN! Returning fallback response.");
        return new ArrayList<>(); 
    }
}