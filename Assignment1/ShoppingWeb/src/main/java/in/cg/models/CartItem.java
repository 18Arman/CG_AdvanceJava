package in.cg.models;

public class CartItem{
	 private Product product;
	    private int quantity;

	    public double getTotal() {
	        return product.getPrice() * quantity;
	    }

		public Product getProduct() {
			return product;
		}

		public void setProduct(Product product) {
			this.product = product;
		}

		public int getQuantity() {
			return quantity;
		}

		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}
	    

}
