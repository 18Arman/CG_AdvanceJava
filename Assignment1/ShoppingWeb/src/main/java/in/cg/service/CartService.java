package in.cg.service;
import in.cg.models.*;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service	
public class CartService {
	private List<CartItem> cart = new ArrayList<>();

	public void addToCart(Product product, int qty){

	    // check if product already exists
	    for(CartItem item : cart){

	        if(item.getProduct().getId()
	                == product.getId()){

	            // increase quantity
	            item.setQuantity(
	                item.getQuantity() + qty
	            );

	            return; // stop here
	        }
	    }

	    // if product not found → add new
	    CartItem newItem = new CartItem();
	    newItem.setProduct(product);
	    newItem.setQuantity(qty);

	    cart.add(newItem);
	}
	public void removeFromCart(int productId){

	    cart.removeIf(item ->
	        item.getProduct().getId() == productId
	    );
	}
    public List<CartItem> getCart(){
        return cart;
    }

    public double getTotal(){
        return cart.stream()
                .mapToDouble(CartItem::getTotal)
                .sum();
    }
}
