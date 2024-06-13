package com.model;

public class CartItem {
	@Override
	public String toString() {
		return "CartItem [cartItemId=" + cartItemId + ", userId=" + userId + ", foodId=" + foodId + ", quantity="
				+ quantity + ", totalPrice=" + totalPrice + ", foodsession=" + foodsession + ", overAllPrice="
				+ overAllPrice + ", getOverAllPrice()=" + getOverAllPrice() + ", getFoodsession()=" + getFoodsession()
				+ ", getCartItemId()=" + getCartItemId() + ", getUserId()=" + getUserId() + ", getFoodId()="
				+ getFoodId() + ", getQuantity()=" + getQuantity() + ", getTotalPrice()=" + getTotalPrice() + "]";
	}

	public int cartItemId;
	public int userId;
	public int foodId;
	public int quantity;

	public double totalPrice;
	public String foodsession;
	public double overAllPrice;

	public double getOverAllPrice() {
		return overAllPrice;
	}

	public void setOverAllPrice(double overAllPrice) {
		this.overAllPrice = overAllPrice;
	}

	public String getFoodsession() {
		return foodsession;
	}

	public void setFoodsession(String foodsession) {
		this.foodsession = foodsession;
	}

	public CartItem(String foodsession) {
		super();
		this.foodsession = foodsession;
	}

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

	public CartItem(int cartItemId, int userId, int foodId, int quantity, double totalPrice, String foodsession) {
		super();
		this.cartItemId = cartItemId;
		this.userId = userId;
		this.foodId = foodId;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
		this.foodsession = foodsession;
	}

	public CartItem(int userId2, int foodId2, int quantity2, double totalPrice2, String foodsession2) {
		this.userId = userId2;
		this.foodId = foodId2;
		this.quantity = quantity2;
		this.totalPrice = totalPrice2;
		this.foodsession = foodsession2;

	}

	public CartItem() {
		// TODO Auto-generated constructor stub
	}

	public void setFoodId(String parameter) {

	}

	public CartItem(int userId, int foodId, int quantity, double totalPrice, String foodsession, double overAllPrice) {
		super();

		this.userId = userId;
		this.foodId = foodId;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
		this.foodsession = foodsession;
		this.overAllPrice = overAllPrice;
	}

	public CartItem(int foodId2, int quantity2) {
	}

}
