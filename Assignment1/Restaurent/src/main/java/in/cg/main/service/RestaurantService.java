package in.cg.main.service;

import in.cg.main.dto.RestaurantDto;
import in.cg.main.entity.Restaurant;
import org.springframework.data.domain.Page;

public interface RestaurantService {

    Restaurant addRestaurant(RestaurantDto dto);

    Page<Restaurant> getAllRestaurants(int page, int size);

}