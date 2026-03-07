package in.cg.main.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public class RestaurantDto {

    @NotBlank(message = "Restaurant name cannot be empty")
    private String name;

    @NotBlank(message = "Location cannot be empty")
    private String location;

    @Positive(message = "Rating must be positive")
    private Double rating;

    public RestaurantDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }
}