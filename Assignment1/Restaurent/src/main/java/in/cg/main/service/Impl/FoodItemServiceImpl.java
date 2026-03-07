package in.cg.main.service.Impl;

import in.cg.main.dto.FoodItemDto;
import in.cg.main.entity.FoodItem;
import in.cg.main.entity.Restaurant;
import in.cg.main.repository.FoodItemRepository;
import in.cg.main.repository.RestaurantRepository;
import in.cg.main.service.FoodItemService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodItemServiceImpl implements FoodItemService {

    @Autowired
    private FoodItemRepository foodItemRepository;

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Override
    public FoodItem addFoodItem(Long restaurantId, FoodItemDto dto) {

        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new RuntimeException("Restaurant not found"));

        FoodItem foodItem = new FoodItem();

        foodItem.setName(dto.getName());
        foodItem.setPrice(dto.getPrice());
        foodItem.setCategory(dto.getCategory());
        foodItem.setRestaurant(restaurant);

        return foodItemRepository.save(foodItem);
    }

    @Override
    public List<FoodItem> getFoodItemsByRestaurant(Long restaurantId) {

        return foodItemRepository.findByRestaurantId(restaurantId);
    }
}