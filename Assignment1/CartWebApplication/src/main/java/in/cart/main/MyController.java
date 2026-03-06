package in.cart.main;

import in.cart.entity.Cart;
import in.cart.entity.Products;
import jakarta.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {

    @GetMapping("/products")
    public ModelAndView openProducts() {
        ModelAndView mv = new ModelAndView("products");
        mv.addObject("products", ProductController.getAllProducts());
        return mv;
    }

    @GetMapping("/cart")
    public ModelAndView openCart(HttpSession session) {
        List<Cart> cartList = (List<Cart>) session.getAttribute("cartList");

        ModelAndView mv = new ModelAndView("cart");
        mv.addObject("cartList", cartList);

        return mv;
    }

    @PostMapping("/addToCart")
    public ModelAndView addToCart(@ModelAttribute Cart cart, HttpSession session) {

        List<Cart> cartList = (List<Cart>) session.getAttribute("cartList");

        if (cartList == null) {
            cartList = new ArrayList<>();
        }

        for (Products p : ProductController.getAllProducts()) {
            if (p.getProductId() == cart.getProductId()) {
                cart.setProductName(p.getProductName());
                cart.setProductDesc(p.getProductDesc());
                cart.setProductImage(p.getProductImage());
                break;
            }
        }

        cartList.add(cart);
        session.setAttribute("cartList", cartList);

        return new ModelAndView("redirect:/products");
    }

    @GetMapping("/removeFromCart")
    public ModelAndView removeFromCart(
            @RequestParam("productId") int productId,
            HttpSession session) {

        List<Cart> cartList = (List<Cart>) session.getAttribute("cartList");

        if (cartList != null) {
            cartList.removeIf(c -> c.getProductId() == productId);
        }

        return new ModelAndView("redirect:/cart");
    }
}