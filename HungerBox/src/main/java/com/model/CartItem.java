package com.model;

public class CartItem {
	public int cartItemId;
	public int userId;
	public int foodId;
	public int quantity;
	public double totalPrice;

	public int getCartItemId() {
		return cartItemId;
	}

	public void setCartItemId(int cartItemId) {
		this.cartItemId = cartItemId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getFoodId() {
		return foodId;
	}

	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Override
	public String toString() {
		return "CartItem [cartItemId=" + cartItemId + ", userId=" + userId + ", foodId=" + foodId + ", quantity="
				+ quantity + ", totalPrice=" + totalPrice + ", getCartItemId()=" + getCartItemId() + ", getUserId()="
				+ getUserId() + ", getFoodId()=" + getFoodId() + ", getQuantity()=" + getQuantity()
				+ ", getTotalPrice()=" + getTotalPrice() + "]";
	}

	
	
	
	
	
	
	public CartItem(int cartItemId, int userId, int foodId, int quantity, double totalPrice) {
		super();
		this.cartItemId = cartItemId;
		this.userId = userId;
		this.foodId = foodId;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
	}

	public CartItem() {
	}

	public CartItem(UserDetails userId2, int foodId2, int quantity2, double totalPrice2) {
		// TODO Auto-generated constructor stub
	}

	public void setFoodId(String parameter) {

	}
}
