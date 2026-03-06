package in.cg.service;

import java.util.*;
import in.cg.models.*;


import org.springframework.stereotype.Service;

@Service
public class ProductService {
		private List<Product> products = new ArrayList<>();
	    public ProductService() {

	        products.add(new Product(1, "Mobile", 30000));
	        products.add(new Product(2, "TV", 50000));
	        products.add(new Product(2, "camera", 100000));
	    }

	    public List<Product> getAllProducts(){
	        return products;
	    }

	    public Product getById(int id){
	        return products.stream()
	                .filter(p->p.getId()==id)
	                .findFirst()
	                .orElse(null);
	    }
}

