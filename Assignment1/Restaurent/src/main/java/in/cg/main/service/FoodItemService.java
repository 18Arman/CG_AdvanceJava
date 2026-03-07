package in.cg.main.service;

import in.cg.main.dto.FoodItemDto;
import in.cg.main.entity.FoodItem;

import java.util.List;

public interface FoodItemService {

    FoodItem addFoodItem(Long restaurantId, FoodItemDto dto);

    List<FoodItem> getFoodItemsByRestaurant(Long restaurantId);

}