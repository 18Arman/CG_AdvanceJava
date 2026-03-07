package in.cg.main.dto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
public class FoodItemDto {

    @NotBlank(message = "Food name cannot be empty")
    private String name;

    @Positive(message = "Price must be positive")
    private Double price;

    private String category;

    public FoodItemDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}