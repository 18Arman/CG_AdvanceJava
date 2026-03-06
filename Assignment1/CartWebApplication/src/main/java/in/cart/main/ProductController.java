package in.cart.main;

import in.cart.entity.Products;
import java.util.ArrayList;
import java.util.List;

public class ProductController {

    public static List<Products> getAllProducts() {

        List<Products> list = new ArrayList<>();

        Products p1 = new Products();
        p1.setProductId(1);
        p1.setProductName("Wireless Headphones");
        p1.setProductDesc("Noise cancelling premium headphones");
        p1.setProductImage("https://images.unsp	lash.com/photo-1505740420928-5e560c06d30e?w=600&h=400&fit=crop");
        list.add(p1);

        Products p2 = new Products();
        p2.setProductId(2);
        p2.setProductName("Smart Watch");
        p2.setProductDesc("Fitness tracking smart watch");
        p2.setProductImage("https://images.unsplash.com/photo-1523275335684-37898b6baf30?w=600&h=400&fit=crop");
        list.add(p2);

        Products p3 = new Products();
        p3.setProductId(3);
        p3.setProductName("Gaming Mouse");
        p3.setProductDesc("RGB high DPI gaming mouse");
        p3.setProductImage("https://images.unsplash.com/photo-1527864550417-7fd91fc51a46?w=600&h=400&fit=crop");
        list.add(p3);

        Products p4 = new Products();
        p4.setProductId(4);
        p4.setProductName("Mechanical Keyboard");
        p4.setProductDesc("Backlit mechanical keyboard");
        p4.setProductImage("https://images.unsplash.com/photo-1587829741301-dc798b83add3?w=600&h=400&fit=crop");
        list.add(p4);

        Products p5 = new Products();
        p5.setProductId(5);
        p5.setProductName("Bluetooth Speaker");
        p5.setProductDesc("Portable deep bass speaker");
        p5.setProductImage("https://images.unsplash.com/photo-1608043152269-423dbba4e7e1?w=600&h=400&fit=crop");
        list.add(p5);

        Products p6 = new Products();
        p6.setProductId(6);
        p6.setProductName("DSLR Camera");
        p6.setProductDesc("Professional photography camera");
        p6.setProductImage("https://images.unsplash.com/photo-1516035069371-29a1b244cc32?w=600&h=400&fit=crop");
        list.add(p6);

        Products p7 = new Products();
        p7.setProductId(7);
        p7.setProductName("Laptop Backpack");
        p7.setProductDesc("Waterproof travel backpack");
        p7.setProductImage("https://images.unsplash.com/photo-1553062407-98eeb64c6a62?w=600&h=400&fit=crop");
        list.add(p7);

        Products p8 = new Products();
        p8.setProductId(8);
        p8.setProductName("Running Shoes");
        p8.setProductDesc("Lightweight sports shoes");
        p8.setProductImage("https://images.unsplash.com/photo-1542291026-7eec264c27ff?w=600&h=400&fit=crop");
        list.add(p8);

        Products p9 = new Products();
        p9.setProductId(9);
        p9.setProductName("Smartphone");
        p9.setProductDesc("High performance flagship phone");
        p9.setProductImage("https://images.unsplash.com/photo-1511707171634-5f897ff02aa9?w=600&h=400&fit=crop");
        list.add(p9);

        Products p10 = new Products();
        p10.setProductId(10);
        p10.setProductName("Wireless Charger");
        p10.setProductDesc("Fast charging wireless pad");
        p10.setProductImage("https://images.unsplash.com/photo-1586953208448-b95a79798f07?w=600&h=400&fit=crop");
        list.add(p10);

        return list;
    }
}