package in.cg.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

import in.cg.models.Product;
import in.cg.service.CartService;
import in.cg.service.ProductService;


	@Controller
	public class MyController{

	    @Autowired
	    private ProductService productService;

	    @Autowired
	    private CartService cartService;
	    @GetMapping("/products")
	    public String showProducts(Model m){

	        System.out.println(
	            productService.getAllProducts()
	        );

	        m.addAttribute("products",
	                productService.getAllProducts());

	        return "products";
	    }
	    
	    @PostMapping("/add")
	    public String addToCart(
	            @RequestParam("id") int id,
	            @RequestParam("qty") int qty){

	        Product p = productService.getById(id);
	        cartService.addToCart(p, qty);

	        return "redirect:/cart";
	    }
	    @PostMapping("/remove")
	    public String removeFromCart(
	    		@RequestParam("id") int id){
	    	
	    	cartService.removeFromCart(id);
	    	
	    	return "redirect:/cart";
	    }
	    //viewing cart
	    @GetMapping("/cart")
	    public String viewCart(Model m){

	        m.addAttribute("cart",
	                cartService.getCart());

	        m.addAttribute("total",
	                cartService.getTotal());

	        return "cart";
	    }
	

}
