package in.cg.main.service.Impl;

import in.cg.main.dto.RestaurantDto;
import in.cg.main.entity.Restaurant;
import in.cg.main.repository.RestaurantRepository;
import in.cg.main.service.RestaurantService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Override
    public Restaurant addRestaurant(RestaurantDto dto) {

        Restaurant restaurant = new Restaurant();

        restaurant.setName(dto.getName());
        restaurant.setLocation(dto.getLocation());
        restaurant.setRating(dto.getRating());

        return restaurantRepository.save(restaurant);
    }

    @Override
    public Page<Restaurant> getAllRestaurants(int page, int size) {

        Pageable pageable = PageRequest.of(page, size);

        return restaurantRepository.findAll(pageable);
    }
}